package com.amdocs.orderDemo.feignClients;


import com.amdocs.orderDemo.request.ProductOrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ProductOrder", url = "http://localhost:8084")
public interface ProductOrderClient {



    @RequestMapping(method = RequestMethod.POST, value = "/productorder")
    Integer addProductOrder (@RequestBody ProductOrderRequest productOrderRequest);
}
