package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Faculty")
public class Faculty {
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String body;

	public Faculty(Long id, String title, String body) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
	}


	public Faculty() {
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


	public void setFacultyId(String string) {
		// TODO Auto-generated method stub
		
	}


	public void setAdminName(String string) {
		// TODO Auto-generated method stub
		
	}


	public Long getFaculty() {
		// TODO Auto-generated method stub
		return null;
	}


	

	public void setFacultyId(long l) {
		// TODO Auto-generated method stub
		
	}


	public void setFacultyName(String string) {
		// TODO Auto-generated method stub
		
	}


	public void setFacultyame(String string) {
		// TODO Auto-generated method stub
		
	}


	




	


	


	
	
	
	
	
	

}
