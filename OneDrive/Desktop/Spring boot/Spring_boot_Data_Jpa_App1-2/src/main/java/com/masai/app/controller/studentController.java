package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.Exception.StudentException;
import com.masai.app.Model.Student;
import com.masai.app.Model.StudentDTO;
import com.masai.app.Service.StudentService;

@RestController
public class studentController {
	
	@Autowired
	private StudentService sService;
	
	@PostMapping("/students")
	public ResponseEntity<Student> saveStudentHandler(@RequestBody Student student){
		Student s =sService.saveStudentDetails(student);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentByRollHandler(@PathVariable("roll" )Integer roll) throws StudentException {
		Student student = sService.getStudentByRoll(roll);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentHandler() throws StudentException{
		
		List<Student> student = sService.getAllStudents();
		return new ResponseEntity<List<Student>>(student,HttpStatus.OK);
	}
	
	@DeleteMapping("/students/{roll}")
	public ResponseEntity<Student> deletedStudentHandler(@PathVariable("roll") Integer roll) throws StudentException{
		
		Student student = sService.deleteStudentByRoll(roll);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
		
	}
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student) throws StudentException{
		Student updateStudent = sService.updateStudentDetail(student);
		return new ResponseEntity<Student>(updateStudent,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/students/{roll}")
	public ResponseEntity<Student> updateStudentMarksHandler(@PathVariable("roll") Integer roll, @RequestParam(value = "gmarks", required = false) Integer gmarks) throws StudentException{
	Student updateStudent = sService.updateStudentMarks(roll, gmarks);	
	return new ResponseEntity<Student>(updateStudent,HttpStatus.ACCEPTED);
	}
	
	
	
	//------------------- Get Student By Marks ---------------------------------------------
	@GetMapping("/getstudents/{marks}")
	public ResponseEntity<List<Student>>  getStudentByMarksHandler(@PathVariable("marks") Integer marks)throws StudentException{
		List<Student> students = sService.getStudentByMarks(marks);
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	
	//---- Get Student by Address ----------------------------------------
	@GetMapping("/getStudentByAddress/{address}")
	public ResponseEntity<Student>  getStudentByAddressHandler(@PathVariable("address" )String address)throws StudentException{
		Student student = sService.getStudentByAddress(address);
		
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	//---- Get Student Name by Roll----------------------------------------
	@GetMapping("/getNameByRoll/{roll}")
	public ResponseEntity<String>  getNameByRollHandler(@PathVariable("roll") Integer roll) throws StudentException{
		String name = sService.getNameByRoll(roll);
		return new ResponseEntity<String>(name,HttpStatus.OK);
		
	}
	
	//---- Get Student Name And Marks by Address ----------------------------------------
	@GetMapping("/getNameAndMarks/{address}")
	public ResponseEntity<List<String>> getNameAndMarksHandler(@PathVariable("address") String address) throws StudentException{
		
		List<String> list = sService.getNameAndMarks(address);
		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/getNameAndMarks2/{address}")
	public ResponseEntity<List<StudentDTO>> getNameAndMarksHandler2(@PathVariable("address") String address) throws StudentException{
		
		List<StudentDTO> list = sService.getNameAndMarks2(address);
		return new ResponseEntity<List<StudentDTO>>(list,HttpStatus.OK);
	}
	
}
