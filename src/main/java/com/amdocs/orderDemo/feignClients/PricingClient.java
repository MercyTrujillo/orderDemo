
package com.amdocs.orderDemo.feignClients;

import com.amdocs.orderDemo.response.PricingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(name = "pricing", url = "http://localhost:8082")
public interface PricingClient {

    @RequestMapping(method = RequestMethod.GET, value = "/pricing/{id}")
    Optional<PricingResponse> getPriceById(@PathVariable("id") Integer id);



}
