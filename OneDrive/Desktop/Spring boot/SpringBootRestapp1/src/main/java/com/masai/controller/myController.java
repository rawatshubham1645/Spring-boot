package com.masai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Student;

//@Controller
@RestController  //(@Controller + @ResponseBody)
// if you want to make whole class give raw data then we can use @Response instead of @Controller 
// and noo need to write the @ResponseBody at every method
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
}
