package com.example.demoistio2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
public class Demoistio2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demoistio2Application.class, args);
	}
	
    @Bean 
    public RestTemplate restTemplate() {
        RestTemplate template = new RestTemplate();

        return template;
    }

}
