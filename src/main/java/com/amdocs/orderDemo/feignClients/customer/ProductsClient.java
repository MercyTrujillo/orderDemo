package com.amdocs.orderDemo.feignClients.customer;


import com.amdocs.orderDemo.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "products", url = "http://localhost:8082/products")
public interface ProductsClient {

    @GetMapping("/customer/{customerID}")
    Optional<CustomerResponse> getCustomer(@PathVariable("customerID") Integer customerID);

}
