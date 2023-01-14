package com.masai.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Address;
import com.masai.Model.Student;

@RestController
@RequestMapping("/app")
public class myController {
	
	//@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@GetMapping("/hello")
	public String sayHello() {
		return "Hii welcome to Spring Boot";
		}
	
	@GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudentHandler() {
		Student student = new Student();
		student.setName("SHubham");
		student.setRoll(01);
		student.setAddress(new Address("pune","Maharastra","24444"));
		student.setMarks(92);
		return student;
	}
	
	//---------------------------Path Variable-------------------------------------------
	
	
	@GetMapping("/student/{roll}")
	public Student getStudentHandler2(@PathVariable("roll") Integer roll) {
		
		//here we can connect with service Layer(SL)-->DL--->DB
		//to get the student details for roll
		Student student = new Student();
		student.setName("SHubham");
		student.setRoll(01);
		student.setAddress(new Address("pune","Maharastra","24444"));
		student.setMarks(92);
		return student;
	}
	
	
	//----------------------Request Parameter----------------------------------------
	
	@GetMapping("/address")
	public Address getAddress(@RequestParam(value="city",required = false) String city,@RequestParam(value = "state",required = false)String state) {
		Address address = new Address(city,state,"44521");
		return address;
	}
	
	
	//---------------------------Post Method----------------------------------------
	
	@PostMapping(value="/postStudent", produces = MediaType.APPLICATION_JSON_VALUE)
	public String saveStudentHandler(@RequestBody Student student) {
		//Student Object need to be persisted inside the DB
		
		return "Student saved Succesfully"+student.toString();
	}
	
	
	
	
}
