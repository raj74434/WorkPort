package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityfilter(HttpSecurity http)
	throws Exception{

	http.csrf().disable()
	.authorizeHttpRequests()
	.antMatchers(HttpMethod.GET,"/say").permitAll()
	.antMatchers(HttpMethod.POST,"/user").permitAll()
	.anyRequest().authenticated()
	.and()
	.formLogin() //  <-- this help in login from browser . It create a login page 
	.and()
	.httpBasic();   //<-- This help in authenticate with postman etc

	return http.build();


	}
	
	 @Bean
	    public PasswordEncoder passwordEncoder() {

	        return new BCryptPasswordEncoder();

	    }
	

}
