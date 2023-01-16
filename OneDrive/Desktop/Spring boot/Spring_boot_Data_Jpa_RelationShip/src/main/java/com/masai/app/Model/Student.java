package com.masai.app.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roll;
	private String name;
	private Integer marks;
	
	@Embedded
	private Address addr; 	//Has-A Relationship
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Course> courses = new ArrayList();
	
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}



	public Student(Integer roll, String name, Integer marks, Address addr, List<Course> courses) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
		this.addr = addr;
		this.courses = courses;
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



	public Integer getMarks() {
		return marks;
	}



	public void setMarks(Integer marks) {
		this.marks = marks;
	}



	public Address getAddr() {
		return addr;
	}



	public void setAddr(Address addr) {
		this.addr = addr;
	}



	public List<Course> getCourses() {
		return courses;
	}



	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}



	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", marks=" + marks + ", addr=" + addr + ", courses="
				+ courses + "]";
	}
	
}
