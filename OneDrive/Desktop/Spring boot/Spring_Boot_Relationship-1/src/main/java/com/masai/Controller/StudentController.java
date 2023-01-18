package com.masai.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.CourseException;
import com.masai.Model.Student;
import com.masai.Service.StudentSerivice;

@RestController
public class StudentController {
	
	
	@Autowired
	private StudentSerivice sService;
	
	
	@PostMapping("/students/{cname}")
	public ResponseEntity<Student> registerStudent(@PathVariable("cname")String cname,@RequestBody Student student) throws CourseException{
		Student students =sService.registerStudent(cname, student);
		return new ResponseEntity<Student>(students,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/students/{cname}")
	public ResponseEntity<Set<Student>> getStudentByCorsenameHandler(@PathVariable("cname" )String sourseName) throws CourseException{
		
		Set<Student> students = sService.findStudentByCourseName(sourseName);
		
		return new ResponseEntity<>(students,HttpStatus.ACCEPTED);
	}
}
