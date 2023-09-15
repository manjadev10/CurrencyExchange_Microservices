package com.manjan.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	//@Retry(name="sample-api", fallbackMethod="fallbackMethod")
	//@CircuitBreaker(name="sample-api",fallbackMethod="fallbackMethod")
	@RateLimiter(name="sample-api")
	public String sampleApi() {
//		logger.info("sample api call received");
//		ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost/wrong-url", String.class);
//		return responseEntity.getBody();
		return "sample-api";
	}
	
	public String fallbackMethod(Exception ex){
		return "fallback-api";
	}

}
