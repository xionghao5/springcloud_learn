package com.gua.pl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class GmPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmPortalApplication.class, args);
    }

}


