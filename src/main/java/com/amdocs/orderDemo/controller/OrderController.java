package com.amdocs.orderDemo.controller;

import com.amdocs.orderDemo.Entities.Order;
import com.amdocs.orderDemo.request.OrderRequest;
import com.amdocs.orderDemo.response.OrderResponse;
import com.amdocs.orderDemo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/order")
    public OrderResponse createOrder (@RequestBody OrderRequest orderRequest){
        return orderService.createOrder(orderRequest);
    }


    @RequestMapping(method = RequestMethod.GET,value = "/order/{orderId}")
    public Optional<Order> getOrderById(@PathVariable Integer orderId){
        return orderService.getOrderById(orderId);

    }
}
