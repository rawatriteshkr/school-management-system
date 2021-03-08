package com.kipragno.tech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/v1")
public class HelloWorldController {

	@GetMapping(value = "/hello")
	public ResponseEntity<?> hello() {
		String response = "Access api using jwt token";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
