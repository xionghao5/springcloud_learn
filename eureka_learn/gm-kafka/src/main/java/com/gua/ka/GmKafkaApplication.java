package com.gua.ka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class GmKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmKafkaApplication.class, args);
    }

}


