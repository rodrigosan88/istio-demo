package com.example.demoistio;

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

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	public DemoRestController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/start")
	public ResponseEntity<String> startCall() {
		ResponseEntity<String> response = this.restTemplate.exchange("http://service-b-svc/step1", HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), String.class);
		
		return ResponseEntity.ok(response.getBody());
	}
	
	@GetMapping("/step2")
	public ResponseEntity<String> step1Call() {
		ResponseEntity<String> response = this.restTemplate.exchange("http://service-b-svc/end", HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), String.class);
		
		return ResponseEntity.ok(response.getBody());
	}
	
	
}
