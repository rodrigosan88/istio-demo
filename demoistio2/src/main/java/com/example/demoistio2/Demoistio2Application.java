package com.example.demoistio2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
public class Demoistio2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demoistio2Application.class, args);
	}
	
    @Bean 
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        
        interceptors.add(new RestTemplateHeaderModifierInterceptor());
        restTemplate.setInterceptors(interceptors);
        
        return restTemplate;
    }

}
