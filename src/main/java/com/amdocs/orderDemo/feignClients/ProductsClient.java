package com.amdocs.orderDemo.feignClients;


import com.amdocs.orderDemo.response.ProductsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(name = "products", url = "http://localhost:8082")
public interface ProductsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/products/{productId}")
    Optional<ProductsResponse> getProductById(@PathVariable("productId") Integer productId);

}
