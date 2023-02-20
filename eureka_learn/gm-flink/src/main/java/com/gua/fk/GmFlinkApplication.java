package com.gua.fk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class GmFlinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmFlinkApplication.class, args);
    }

}


