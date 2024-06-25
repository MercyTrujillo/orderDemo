package com.amdocs.orderDemo.services;

import com.amdocs.orderDemo.Entities.Order;
import com.amdocs.orderDemo.OrderDemoApplication;
import com.amdocs.orderDemo.feignClients.CustomerClient;
import com.amdocs.orderDemo.feignClients.PricingClient;
import com.amdocs.orderDemo.feignClients.ProductOrderClient;
import com.amdocs.orderDemo.feignClients.ProductsClient;
import com.amdocs.orderDemo.request.ProductOrderRequest;
import com.amdocs.orderDemo.response.*;
import com.amdocs.orderDemo.repository.OrderRepository;
import com.amdocs.orderDemo.request.OrderRequest;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    private ProductOrderClient productOrderClient;


    @Autowired
    private PricingClient pricingClient;



    public OrderResponse createOrder(OrderRequest orderRequest){
        Order order = new Order();

        order.setTotalDiscount(orderRequest.getDiscount());
        order.setCustomer(orderRequest.getCustomerID());
        System.out.println("customer id:  " +orderRequest.getCustomerID());
        order.setCreationDate(LocalDate.now());
        OrderResponse response = new OrderResponse();
        try {
            Optional<CustomerResponse> optionalCustomerResponse = customerClient.getCustomerById(orderRequest.getCustomerID());
            response.setCustomer(optionalCustomerResponse.get());
        } catch (EntityNotFoundException ex) {
            log.error(ex.getMessage());
        }
        order = orderRepository.save(order);
        List<ProductsResponse> productsList = new ArrayList<>();
        for (ProductOrderRequest product: orderRequest.getProducts()) {
            ProductOrderRequest request = mapOrderRequest(order.getOrderId(), product.getProductID(), product.getQuantity());
            System.out.println(order.getOrderId() + "  " + product.getProductID() + "  " + product.getQuantity());
            Integer productOrderId = productOrderClient.addProductOrder(request);



            Optional<ProductsResponse> optionalProductsResponse = productsClient.getProductById(product.getProductID());
            productsList.add(optionalProductsResponse.get());
            optionalProductsResponse.get().setQuantity(product.getQuantity());
            response.setProducts(productsList);





        }
        response.setOrderId(order.getOrderId());
        response.setTotalDiscount(order.getTotalDiscount());
        return response;
    }

    private ProductOrderRequest mapOrderRequest(Integer orderId, Integer productId, Integer quantity) {
        ProductOrderRequest request = new ProductOrderRequest(); //el request de tu client a Product Order
        request.setOrderID(orderId);
        request.setProductID(productId);
        request.setQuantity(quantity);

        return request;
    }







    public Optional<Order> getOrderById(Integer orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order;
    }



}