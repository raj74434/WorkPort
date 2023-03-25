package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {

	public Optional<Users> findByEmail(String mobile);
	
}
