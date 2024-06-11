package com.amdocs.orderDemo.feignClients.customer;


import com.amdocs.orderDemo.response.CustomerResponse;
import com.amdocs.orderDemo.response.ProductsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "products", url = "http://localhost:8082")
public interface ProductsClient {

    @GetMapping("/products/{productId}")
    Optional<ProductsResponse> getProduct(@PathVariable("productsId") Integer productId);

}
