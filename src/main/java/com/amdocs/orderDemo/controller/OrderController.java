package com.amdocs.orderDemo.controller;

import com.amdocs.orderDemo.Entities.Order;
import com.amdocs.orderDemo.request.OrderRequest;
import com.amdocs.orderDemo.response.OrderResponse;
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


    @RequestMapping(method = RequestMethod.POST, value = "/order")
    public ResponseEntity<OrderResponse> createOrder (@RequestBody OrderRequest orderRequest){
        OrderResponse orderResponse = orderService.createOrder(orderRequest);
        return ResponseEntity.ok(orderResponse);

    }

    @RequestMapping(method = RequestMethod.GET,value = "/order/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Integer orderId){
         OrderResponse order = orderService.getOrderById(orderId);
         return ResponseEntity.ok(order);

    }

    @DeleteMapping(value = "/order/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Order successfully removed");

    }


    @PatchMapping(value = "/order/{orderId}")
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable Integer orderId, @RequestBody OrderRequest newOrder ){
        OrderResponse orderResponse = orderService.updateOrder(orderId, newOrder);
        return ResponseEntity.ok(orderResponse);
    }




}
