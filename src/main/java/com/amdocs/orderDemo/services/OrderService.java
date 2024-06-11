package com.amdocs.orderDemo.services;

import com.amdocs.orderDemo.Entities.Order;
import com.amdocs.orderDemo.OrderDemoApplication;
import com.amdocs.orderDemo.feignClients.customer.CustomerClient;
import com.amdocs.orderDemo.feignClients.customer.ProductsClient;
import com.amdocs.orderDemo.response.CustomerResponse;
import com.amdocs.orderDemo.repository.OrderRepository;
import com.amdocs.orderDemo.request.OrderRequest;
import com.amdocs.orderDemo.response.OrderResponse;
import com.amdocs.orderDemo.response.ProductsResponse;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderDemoApplication.class);


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private ProductsClient productsClient;


    public OrderResponse createOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setDiscount(orderRequest.getDiscount());
        order.setCustomer(orderRequest.getCustomerID());
        System.out.println("customer id:  " +orderRequest.getCustomerID());
        order.setCreationDate(LocalDate.now());

        OrderResponse response = new OrderResponse();
        try {
            // pass ID
            Optional<CustomerResponse> optionalCustomerResponse = customerClient.getCustomerById(orderRequest.getCustomerID());
            response.setCustomerResponse(optionalCustomerResponse.get());
        } catch (EntityNotFoundException ex) {
            log.error(ex.getMessage());
        }
        order = orderRepository.save(order);

       return response;

    }

    public Optional<Order> getOrderById(Integer orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order;
    }



}