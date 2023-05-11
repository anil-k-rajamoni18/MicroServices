package com.example.springannotations.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
@Profile(value = {"dev","stg","prod"})
public class BeanConfig {

    @Bean
    public TestBean testBean(){
        return  new TestBean();
    }

    @Bean
    RestTemplate restTemplate(){
        return  new RestTemplate();
    }

    @Value("${db.driverClass}")
    private String driverClass;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Bean

    public String dataSourceProps() {
        System.out.println(driverClass + " : " + url + " : " + username + " : " + password);
        return "dataSource connection for dev";
    }
}
