package com.gua.xj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @author 86188
 */
@SpringBootApplication
@EnableEurekaClient
public class GmXxljobApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmXxljobApplication.class, args);
    }

}


