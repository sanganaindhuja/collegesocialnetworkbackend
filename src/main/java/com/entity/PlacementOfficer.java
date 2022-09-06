package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlacementOfficer {
	
  @Id
  private Long id;
  private String name;
public PlacementOfficer(Long id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public PlacementOfficer() {
	super();
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "PlacementOfficer [id=" + id + ", name=" + name + "]";
}
  
  

}
