package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.Sprint;
import com.example.demo.models.Task;
import com.example.demo.models.UserDTO;
import com.example.demo.models.Users;
import com.example.demo.repository.SprintRepo;
import com.example.demo.repository.UserRepo;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepo ur;
	
	@Autowired
	private SprintRepo sr;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Users register(UserDTO user) {
		Users us=new Users();
		us.setEmail(user.getEmail());
		us.setFirstName(user.getFirstName());
		us.setLastName(user.getLastName());
		
		us.setPassword(passwordEncoder.encode(user.getPassword()));
		return ur.save(us);
	}
	
	public List<Sprint> newSprint(Authentication auth, Sprint sprint) {
		String email=auth.getName();
		Users users=ur.findByEmail(email).orElseThrow(() -> new BadCredentialsException("User not found by email "+email));
		
		users.setSprints(sprint);
		 ur.save(users);
		 return users.getSprints();
	}

	public List<Sprint> assign(Authentication auth, Sprint sprint,String email) {
//		String em=auth.getName();
		Users users=ur.findByEmail(email).orElseThrow(() -> new BadCredentialsException("User not found by email "+email));
		
		users.setSprints(sprint);
		 ur.save(users);
		 return users.getSprints();
	}

	public Sprint addTask(Authentication auth, Integer sprintid,Task task) {
//		String em=auth.getName();
		Sprint sprint=sr.findById(sprintid).orElseThrow(() -> new BadCredentialsException("Sprint not found "));
		
		sprint.setTasks(task);
		return sr.save(sprint);
		 
	}
	
	
}
