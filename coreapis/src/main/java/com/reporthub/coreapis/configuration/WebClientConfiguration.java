package com.reporthub.coreapis.configuration;

import com.reporthub.coreapis.constants.ClientConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Bean
    public WebClient webClient(){
        return WebClient.builder().
                baseUrl(ClientConstants.BASEURL).
                build();
    }
}
