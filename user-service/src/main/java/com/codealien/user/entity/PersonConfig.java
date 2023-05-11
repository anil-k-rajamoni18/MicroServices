package com.codealien.user.entity;

import com.codealien.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class PersonConfig {


    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
          Person p1 = new Person("Anil","Kumar","ak@ou.com",1L);
          Person p2 = new Person("Kumar","Rajamoni","rk@ou.com",2L);
          Person p3 = new Person("Anee","R","anee@ou.com",3L);
          userRepository.saveAll(Arrays.asList(p1,p2,p3));
        };
    }
}
