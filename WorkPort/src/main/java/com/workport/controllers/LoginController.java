package com.workport.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workport.models.Users;
import com.workport.repository.UsersRepo;

@RestController
public class LoginController {

	  @Autowired
	    private UsersRepo userRepo;


	    @GetMapping("/signIn")
	    public ResponseEntity<Users> signIn(Authentication authentication){

	      Users users =  userRepo.findByEmail(authentication.getName()).orElseThrow(() ->new BadCredentialsException("Bad credentials."));

	      return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
	    }
	
}
