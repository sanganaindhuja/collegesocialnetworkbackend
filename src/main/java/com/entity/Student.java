package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Student")
public class Student {
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String body;

	public Student(Long id, String title, String body) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
	}


	public Student() {
		super();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", title=" + title + ", body=" + body + "]";
	}
	
	
	
	
	
	

}
