package com.codealien.department.entity;

import com.codealien.department.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DepartmentConfig {

    @Bean
    CommandLineRunner commandLineRunner(DepartmentRepository departmentRepository){
        return args -> {
            Department d1 = new Department("CSE","HYD","CS-001");
            Department d2 = new Department("ECE","AP","EC-002");
            Department d3 = new Department("EEE","SEC","EEE-003");
            departmentRepository.saveAll(Arrays.asList(d1,d2,d3));
        };
    }
}
