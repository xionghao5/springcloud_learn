package com.gua.gm.client;

import com.gua.gm.client.pojo.Customer;
import com.gua.gm.config.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gm-customer", configuration = FeignConfig.class)
public interface GmCustomerClient {
    @GetMapping("/customer/get")
    Customer get(@RequestParam(value = "cusId") Long cusId);
}
