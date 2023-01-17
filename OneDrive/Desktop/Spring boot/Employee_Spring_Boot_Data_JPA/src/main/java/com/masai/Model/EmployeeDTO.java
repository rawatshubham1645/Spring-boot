package com.masai.Model;

import org.springframework.lang.NonNull;

public class EmployeeDTO {
	@NonNull
	private String empName;
	private String address;
	private Integer salary;
	public EmployeeDTO() {
		super();
	}
	
	public EmployeeDTO(String name, String address, Integer salary) {
		super();
		this.empName = name;
		this.address = address;
		this.salary = salary;
	}

	public String getName() {
		return empName;
	}
	public void setName(String name) {
		this.empName = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [name=" + empName + ", address=" + address + ", salary=" + salary + "]";
	}
	

}
