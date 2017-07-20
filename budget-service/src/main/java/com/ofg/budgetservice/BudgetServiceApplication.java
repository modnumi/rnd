package com.ofg.budgetservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BudgetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetServiceApplication.class, args);
	}
	
}
