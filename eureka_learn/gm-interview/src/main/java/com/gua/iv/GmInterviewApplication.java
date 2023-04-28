package com.gua.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableEurekaClient
public class GmInterviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmInterviewApplication.class, args);
    }

}


