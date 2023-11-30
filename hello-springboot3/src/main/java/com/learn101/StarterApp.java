package com.learn101;

import org.springframework.boot.SpringApplication;



public class StarterApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(HelloSpringWorld.class);
        springApplication.run();
    }
}
