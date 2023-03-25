package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.models.Users;
import com.example.demo.repository.UserRepo;


@Service
public class SecurityUserDetailsService implements UserDetailsService  {

//	This help is implement sequrity .we implement UserDetailsService and there is a method loadUserByUsername
//	both help in implemnet sequrity
	
//	There is a implementation that class name is User .See in method below
	
	@Autowired
	private UserRepo ur;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> u=ur.findByEmail(username);
		
		if(u.isPresent()) {
			Users ur=u.get();
			List<GrantedAuthority> authorities=new ArrayList<>(); //<-- list of aAuthority with user have
//			authorities.add(new SimpleGrantedAuthority(u.getRole()));
			
			
			return new User (ur.getEmail(),ur.getPassword(),authorities);
			
		}
		else {
			throw new UsernameNotFoundException("No user found with this mobile number "+username);
		}
		
		
		
		
	}

}
