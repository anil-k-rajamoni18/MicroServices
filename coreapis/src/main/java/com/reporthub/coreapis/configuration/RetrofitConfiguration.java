package com.reporthub.coreapis.configuration;

import com.reporthub.coreapis.constants.ClientConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
@Configuration
public class RetrofitConfiguration {

    @Bean
    public Retrofit getInstance(){
        return  new Retrofit.Builder()
                .baseUrl(ClientConstants.TODO_BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
