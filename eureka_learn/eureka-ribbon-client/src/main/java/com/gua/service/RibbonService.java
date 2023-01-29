package com.gua.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public interface RibbonService {
    @HystrixCommand(fallbackMethod = "getHomeError")
    String getHome();

    String getHomeError();
}
