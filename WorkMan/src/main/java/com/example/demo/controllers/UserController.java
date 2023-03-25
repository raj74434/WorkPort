package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Sprint;
import com.example.demo.models.UserDTO;
import com.example.demo.models.Users;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserServiceImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController

public class UserController {
	@Autowired
	private UserServiceImpl usi;
	
	@Autowired
	private UserRepo ur;
	
	@GetMapping("/say")
	@CrossOrigin
	public Users  say() {
		System.out.println("Method called");
		Users us=ur.findByEmail("12").get();
		return us ;
	}
	
	@PostMapping("/user")
//	@CrossOrigin
	public ResponseEntity<Users> register(@RequestBody UserDTO us) {
		return new ResponseEntity<>(  usi.register(us),HttpStatus.CREATED);
	}
	
	@PostMapping("/newsprint")
//	@CrossOrigin
	public ResponseEntity<List<Sprint>> newSprint(Authentication auth,@RequestBody Sprint sprint) {
		return new ResponseEntity<>(  usi.newSprint(auth,sprint),HttpStatus.CREATED);
	}

}
