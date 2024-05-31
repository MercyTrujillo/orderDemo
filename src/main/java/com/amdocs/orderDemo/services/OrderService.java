package com.amdocs.orderDemo.services;

import com.amdocs.orderDemo.Entities.Order;
import com.amdocs.orderDemo.feignClients.customer.CustomerClient;
import com.amdocs.orderDemo.feignClients.customer.CustomerResponse;
import com.amdocs.orderDemo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {


    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private OrderRepository orderRepository;

    public Optional<Order> getOrder(Integer orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order;
    }


    public OrderService(CustomerClient customerClient){
        this.customerClient = customerClient;
    }

    public Optional<CustomerResponse> getCustomerClient(Integer customerID) {
        Optional<CustomerResponse> customerResponse = customerClient.getCustomer(customerID);
        return customerResponse;
    }
}
