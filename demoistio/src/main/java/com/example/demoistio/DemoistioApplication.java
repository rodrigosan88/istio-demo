package com.example.demoistio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
public class DemoistioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoistioApplication.class, args);
	}
	
    @Bean 
    public RestTemplate restTemplate() {
        RestTemplate template = new RestTemplate();

        return template;
    }

}
