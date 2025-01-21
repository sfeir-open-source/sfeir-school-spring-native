package com.sfeir.codelabs.springnative.http;

import org.springframework.http.ResponseEntity;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface HeatlhSpringResource {

	@GetExchange(url = "/actuator/health")
	ResponseEntity<String> health();
}

