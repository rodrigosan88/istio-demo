package com.example.demoistio2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoRestController {
	
	private RestTemplate restTemplate;
	
	@Autowired
	public DemoRestController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/step1")
	public ResponseEntity<String> step1Call() {
		ResponseEntity<String> response = this.restTemplate.exchange("http://service-a-svc/step2", HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), String.class);
		
		return ResponseEntity.ok(response.getBody());
	}	
	
	@GetMapping("/end")
	public ResponseEntity<String> startCall() {	
		return ResponseEntity.ok("Service B => end call");
	}
	
}
