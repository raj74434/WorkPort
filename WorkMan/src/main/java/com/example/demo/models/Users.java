package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	
	private String firstName ;
	private String lastName ;
	
	
	@Column(unique = true)
	private String email ;
	
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Sprint> sprints=new ArrayList<>();
	
	
	
	public List<Sprint> getSprints() {
		return sprints;
	}
	public void setSprints(Sprint sprints) {
		this.sprints.add(sprints);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
}
