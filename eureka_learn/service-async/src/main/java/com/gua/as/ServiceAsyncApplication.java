package com.gua.as;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableAsync
public class ServiceAsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAsyncApplication.class, args);
	}

}


