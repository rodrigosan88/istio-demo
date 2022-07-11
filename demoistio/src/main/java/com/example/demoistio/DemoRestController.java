package com.example.demoistio;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoRestController {

	private RestTemplate restTemplate;

	private final static String SERVICE_B = "http://service-b-svc";
	
	public DemoRestController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/start")
	public ResponseEntity<String> startCall(@RequestHeader HttpHeaders headers) {
		ResponseEntity<String> response = this.restTemplate.exchange(SERVICE_B + "/step1", HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), String.class);
		
		return ResponseEntity.ok(response.getBody());
	}
	
	@GetMapping("/step2")
	public ResponseEntity<String> step1Call(@RequestHeader HttpHeaders headers) {
		ResponseEntity<String> response = this.restTemplate.exchange(SERVICE_B + "/end", HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), String.class);
		
		return ResponseEntity.ok(response.getBody());
	}
	
	
}
