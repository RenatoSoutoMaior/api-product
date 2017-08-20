package com.api.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableJpaRepositories
public class ApiProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProductApplication.class, args);
	}

}
