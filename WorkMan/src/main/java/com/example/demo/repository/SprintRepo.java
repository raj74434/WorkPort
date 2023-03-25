package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Sprint;

public interface SprintRepo extends JpaRepository<Sprint, Integer> {
	
	

}
