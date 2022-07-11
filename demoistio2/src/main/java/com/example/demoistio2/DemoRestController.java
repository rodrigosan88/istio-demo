package com.example.demoistio2;

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

	private final static String SERVICE_A = "http://service-a-svc";
	
	public DemoRestController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/step1")
	public ResponseEntity<String> step1Call(@RequestHeader HttpHeaders headers) {
		ResponseEntity<String> response = this.restTemplate.exchange(SERVICE_A + "/step2", HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), String.class);
		
		return ResponseEntity.ok(response.getBody());
	}	
	
	@GetMapping("/end")
	public ResponseEntity<String> startCall(@RequestHeader HttpHeaders headers) {	
		return ResponseEntity.ok("Service B => end call");
	}
	
}
