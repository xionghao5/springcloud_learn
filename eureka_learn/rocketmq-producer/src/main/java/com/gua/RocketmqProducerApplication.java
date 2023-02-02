package com.gua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class RocketmqProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketmqProducerApplication.class, args);
	}

}


