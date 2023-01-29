package com.gua.client;

import com.gua.client.config.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client",configuration = FeignConfig.class,fallback = FeginClientHystrix.class)
public interface FeginClient {
    @GetMapping("/home")
    String getHomeFromProvider();
}
