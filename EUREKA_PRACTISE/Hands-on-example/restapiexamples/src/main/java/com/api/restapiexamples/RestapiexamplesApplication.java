package com.api.restapiexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestapiexamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiexamplesApplication.class, args);
	}

}
