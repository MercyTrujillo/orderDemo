package com.amdocs.orderDemo.services;

import com.amdocs.orderDemo.Entities.Order;
import com.amdocs.orderDemo.feignClients.customer.CustomerClient;
import com.amdocs.orderDemo.feignClients.customer.ProductsClient;
import com.amdocs.orderDemo.response.CustomerResponse;
import com.amdocs.orderDemo.repository.OrderRepository;
import com.amdocs.orderDemo.request.OrderRequest;
import com.amdocs.orderDemo.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OrderService {



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
        order.setCreationDate(LocalDate.now());
        order = orderRepository.save(order);

        // pass ID
        Optional<CustomerResponse> optionalCustomerResponse = customerClient.getCustomerById(1);



        // Map Response
        OrderResponse response = new OrderResponse();
        response.setCustomerResponse(optionalCustomerResponse.get());

      return response;

    }

    public Optional<Order> getOrderById(Integer orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order;
    }



}
