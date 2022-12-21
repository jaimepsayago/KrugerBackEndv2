package com.kruger.mvc.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class Grade {
	
	//VALIDACIONES agregados en los modelos
	@NotBlank(message="nombre no puede estar vacio")
	private String name;
	
	@NotBlank(message="subject no puede estar vacio")
	private String subject;
	
	private String score;
	
	private String id;
	
	
	public Grade() {
		this.id=UUID.randomUUID().toString();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getScore() {
		return score;
	}


	public void setScore(String score) {
		this.score = score;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Grade [name=" + name + ", subject=" + subject + ", score=" + score + ", id=" + id + "]";
	}
	
	
	

}
