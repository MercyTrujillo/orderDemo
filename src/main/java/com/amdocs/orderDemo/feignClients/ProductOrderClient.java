package com.amdocs.orderDemo.feignClients;


import com.amdocs.orderDemo.request.ProductOrderRequest;
import com.amdocs.orderDemo.response.ProductOrderResponse;
import com.amdocs.orderDemo.response.ProductsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "ProductOrder", url = "http://localhost:8084")
public interface ProductOrderClient {



    @RequestMapping(method = RequestMethod.POST, value = "/productorder")
    Integer addProductOrder (@RequestBody ProductOrderRequest productOrderRequest);


    @RequestMapping(method = RequestMethod.GET, value = "/productorder/{orderId}")
    List<ProductOrderResponse> findByOrderID(@PathVariable("orderId") Integer orderId);

}
