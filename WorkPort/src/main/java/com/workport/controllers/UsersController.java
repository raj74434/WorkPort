package com.workport.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

	@GetMapping("/y")
	public ResponseEntity<String> yes(){
		return new ResponseEntity<>("Yes is caling",HttpStatus.ACCEPTED);
	}
	
	
}
