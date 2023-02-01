package com.gua.so.feign.client;

import com.gua.so.feign.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "service-account",configuration = FeignConfig.class)
public interface ServiceAccountClient {
    @GetMapping("/account/create")
    String accountCreate();
}
