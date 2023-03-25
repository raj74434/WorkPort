package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Users;
import com.example.demo.repository.UserRepo;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@RestController

public class LoginController {
	@Autowired
    private UserRepo userRepo;


    @GetMapping("/signIn")
//    @CrossOrigin
    public ResponseEntity<Users> signIn(Authentication authentication){

      Users users =  userRepo.findByEmail(authentication.getName()).orElseThrow(() ->new BadCredentialsException("Bad credentials This is."));

      return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
    }
}
