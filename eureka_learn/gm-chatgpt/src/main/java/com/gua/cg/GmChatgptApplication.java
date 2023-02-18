package com.gua.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class GmChatgptApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmChatgptApplication.class, args);
    }

}


