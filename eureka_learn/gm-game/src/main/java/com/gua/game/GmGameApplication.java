package com.gua.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class GmGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmGameApplication.class, args);
    }

}


