package com.masai.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Student {
	
	@Min(value = 100, message = "Minimum Roll number should be 100")
	private Integer roll;
	
	@NotNull(message = "{roll.invalid}")
	@Size(min = 3,max = 15,message = "{name.invalid}")
	private String name;
	private Address address;
	private Integer marks;
	
	
	public Student() {
		super();
	}
	public Student(Integer roll, String name, Address address, Integer marks) {
		super();
		this.roll = roll;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
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
