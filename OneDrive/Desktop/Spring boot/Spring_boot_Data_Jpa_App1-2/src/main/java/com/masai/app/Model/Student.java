package com.masai.app.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roll;
	private String name;
	private String address;
	private Integer marks;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


public Student( String name, String address, Integer marks) {
	super();
	
	this.name = name;
	this.address = address;
	this.marks = marks;
}


public Integer getRoll() {
	return roll;
}


public void setRoll(Integer roll) {
	this.roll = roll;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public Integer getMarks() {
	return marks;
}


public void setMarks(Integer marks) {
	this.marks = marks;
}


@Override
public String toString() {
	return "Student [roll=" + roll + ", name=" + name + ", address=" + address + ", marks=" + marks + "]";
}

}
