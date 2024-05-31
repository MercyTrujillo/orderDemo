package com.amdocs.orderDemo.controller;

import com.amdocs.orderDemo.Entities.Order;
import com.amdocs.orderDemo.OrderServiceClient;
import com.amdocs.orderDemo.feignClients.customer.CustomerResponse;
import com.amdocs.orderDemo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }



    @RequestMapping(method = RequestMethod.GET,value = "/order/{orderId}")
    public Optional<Order> getOrder(@PathVariable Integer orderId){
        return orderService.getOrder(orderId);

    }
}
