package com.workport.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workport.models.Users;

public interface UsersRepo extends JpaRepository<Users,Integer> {

	public Optional<Users> findByEmail(String email);
	
	
}
