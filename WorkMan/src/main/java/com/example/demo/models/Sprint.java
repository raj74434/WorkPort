package com.example.demo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Sprint {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private LocalDate start;
	private LocalDate end;
	
	private String features;
	private String story;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Task> tasks=new ArrayList<>();
	
	@ElementCollection
	List<Users> members=new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Task tasks) {
		this.tasks.add(tasks);
	}

	public List<Users> getMembers() {
		return members;
	}

	public void setMembers(Users members) {
		this.members.add(members) ;
	}
	
	
	
	
	
}
