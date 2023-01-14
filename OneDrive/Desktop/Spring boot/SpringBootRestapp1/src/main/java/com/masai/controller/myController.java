package com.masai.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Student;

//@Controller
@RestController  //(@Controller + @ResponseBody)
// if you want to make whole class give raw data then we can use @Response instead of @Controller 
// and no need to write the @ResponseBody at every method
@RequestMapping("/studentapp")
public class myController {
	
	
	//http://localhost:8080/welcome
	
	@RequestMapping("/welcome")
	//@ResponseBody
	public String myWelcomeService() {
		return "Welcome to Spring boot";
		//Note:-> by default returned value from the @RequestMapping annotated method will be treated
		//as logical name of physical JSP file. but in order to tell the spring bOot, treat the returned
		//value as raw data then we need to make use of @ResponseBody annotation
	}
	
	@RequestMapping("/hello")
	public String myHello() {
		return "Inside MmyHello function";
	}
	
	@RequestMapping("/student")
	public Student myStudent(){
		Student student = new Student(01,"Shubham","pune",99);
		return student;
	}
	
	@RequestMapping("/allStudents")
	//@RequestMapping(value = "/allStudents", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//	@GetMapping(value = "/allStudents", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/allStudents") //Shortcut
	public List<Student> getAllStudent(){
		List<Student> students = Arrays.asList(
				new Student(01,"Shubham","pune",99),
				new Student(02,"sourabh","Mumbai",99),
				new Student(03,"kunal","Delhi",99),
				new Student(04,"paras","Goa",99));
		return students;
	}
}
