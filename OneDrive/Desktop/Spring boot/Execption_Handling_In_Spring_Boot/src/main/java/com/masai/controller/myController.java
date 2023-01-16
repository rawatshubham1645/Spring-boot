package com.masai.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.InvalidNumberException;
import com.masai.Model.Address;
import com.masai.Model.Student;

import jakarta.validation.Valid;



@RestController

public class myController {
	
	@RequestMapping("/hello/{num}")
	public ResponseEntity< String >sayHello(@PathVariable("num")Integer num) {
		
		if(num<0)throw new InvalidNumberException("Number should be greater than 0 ");
		int result = num/0;
		return new ResponseEntity<>("Welcome"+result,HttpStatus.OK);
	}
	@PostMapping("/students")
	public String saveStudentHandler(@Valid @RequestBody Student student) {
		return "Saved...."+student;
	}
	
}
