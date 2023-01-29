package com.gua.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonServiceImpl implements RibbonService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getHomeError")
    public String getHome() {
        return restTemplate.getForObject("http://eureka-client/home", String.class);
    }

    @Override
    public String getHomeError() {
        return "sorry,error";
    }
}
