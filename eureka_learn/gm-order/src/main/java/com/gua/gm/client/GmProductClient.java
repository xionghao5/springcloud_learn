package com.gua.gm.client;

import com.gua.gm.client.pojo.Customer;
import com.gua.gm.client.pojo.Product;
import com.gua.gm.config.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gm-product", configuration = FeignConfig.class)
public interface GmProductClient {
    @GetMapping("/product/get")
    Product get(@RequestParam(value = "productId") Long productId);
}
