package com.amdocs.orderDemo.feignClients;

import com.amdocs.orderDemo.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "customer", url = "http://localhost:8083")
public interface CustomerClient {

    @GetMapping("/customer/{customerID}")
    Optional<CustomerResponse> getCustomerById(@PathVariable("customerID") Integer customerID);

}
