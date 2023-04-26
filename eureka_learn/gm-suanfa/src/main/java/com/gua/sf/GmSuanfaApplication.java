package com.gua.sf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
算法相关
 */
@SpringBootApplication
@EnableEurekaClient
public class GmSuanfaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmSuanfaApplication.class, args);
    }

}


