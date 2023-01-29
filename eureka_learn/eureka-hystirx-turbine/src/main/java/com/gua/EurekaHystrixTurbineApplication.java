package com.gua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;


@SpringBootApplication
@EnableTurbine
public class EurekaHystrixTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaHystrixTurbineApplication.class, args);
	}

}


