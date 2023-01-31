package com.gua;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
@EnableTurbine
@EnableHystrix
@EnableHystrixDashboard
public class EurekaAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaAdminServerApplication.class, args);
	}

}


