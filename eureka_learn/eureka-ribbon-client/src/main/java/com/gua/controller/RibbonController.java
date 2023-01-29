package com.gua.controller;


import com.gua.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/ribbon")
    public String ribbon() {
        return ribbonService.getHome();
    }

    @GetMapping("/loadBalance")
    public String loadBalance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        return serviceInstance.getHost() + ":" + serviceInstance.getPort();
    }
}
