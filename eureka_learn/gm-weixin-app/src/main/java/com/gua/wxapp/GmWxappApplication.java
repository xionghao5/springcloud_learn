package com.gua.wxapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @author 86188
 */
@SpringBootApplication
@EnableEurekaClient
public class GmWxappApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmWxappApplication.class, args);
    }

}


