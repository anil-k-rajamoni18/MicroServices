package com.reporthub.coreapis;

import com.reporthub.coreapis.configuration.APIRegistryProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(APIRegistryProps.class)
@SpringBootApplication
public class CoreapisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreapisApplication.class, args);
	}

}
