package com.learn.securitypoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.learn.securitypoc.entity")
public class SecurityPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityPocApplication.class, args);
	}

}
