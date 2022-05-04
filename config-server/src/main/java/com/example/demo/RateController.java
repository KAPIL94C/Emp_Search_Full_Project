package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateController {
	
	@Value("${my.app: default message}")
	private String greetingMessage;
	
	@Value("some static message")
	private String staticMessage;
	
	
	@GetMapping("/greeting")
	String greeting() {
		return greetingMessage + staticMessage;
	}
	

}
