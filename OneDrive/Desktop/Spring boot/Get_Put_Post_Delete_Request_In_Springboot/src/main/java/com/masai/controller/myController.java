package com.masai.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Address;
import com.masai.Model.Student;

import jakarta.annotation.PostConstruct;

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
	
	@PostMapping(value="/postStudent", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveStudentHandler(@RequestBody Student student) {
		//Student Object need to be persisted inside the DB
		
		return "Student saved Succesfully"+student.toString();
	}
	
	
	@PostMapping(value = "/listStudent",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String postListStudent(@RequestBody List<Student> students) {
		return students.toString();
	}
	
	
	
	
	
	
	
	//------------------------------------Put Method ---------------------------------------
	
	//----------------------------------Request Parameter ----------------------------------
	@PutMapping("/updateStudent/{marks}")
	public Student  updateStudent(@RequestBody Student student,@PathVariable("marks") Integer marks) {
		
		//using roll we need to get the existing detail which we need to update with
		// request body parameter. 
		
		student.setMarks(student.getMarks()+marks);
		return student;
		
		
	}
	
	
	
	
	//------------------------------ Response Entity --------------------------------
	@PutMapping("/students/{marks}")
	public ResponseEntity<Student> responseEntityStudent(@RequestBody Student student,@PathVariable("marks") Integer marks) {
		
		
		student.setMarks(student.getMarks()+marks);
		
		//If we want to give some additional headers
		HttpHeaders hh = new HttpHeaders();
		hh.add("user", "Shubham");
		hh.add("token","454612");
		ResponseEntity<Student> re = new ResponseEntity<>(student,hh,HttpStatus.ACCEPTED);
		return re;
		
	}
	
	
	//------------------------------------- Get all Students List ----------------------------------------------------------
	
	private Map<Integer,Student> map = new HashMap<>();
	@PostConstruct
	public void setUp() {
		map.put(1,new Student(1,"shubham",new Address("pune","MH","454745"),97));
		map.put(2,new Student(2,"sourabh",new Address("delhi","MH","454745"),97));
		map.put(3,new Student(3,"kunal",new Address("pune","MH","454745"),97));
		map.put(4,new Student(4,"paras",new Address("pune","MH","454745"),97));
	}
	
	
	@GetMapping("/mapStudents")
	public ResponseEntity< List<Student>> getAllStudentHandler(){
		//map.value will return all the collection of value
		//here value are in the form of map values 
		Collection<Student> col = map.values();
		
		//Now convert the collection into list form
		List<Student> list = new ArrayList<>(col);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	
	//-------------------------------- Add One Student -------------------------------
	@PostMapping("/saveStudent")
	public ResponseEntity< String > saveStudents(@RequestBody  Student student) {
		
		map.put(student.getRoll(), student);
		return new ResponseEntity<>("student saved ",HttpStatus.CREATED);
		
	}
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentByRoll(@PathVariable("roll" )Integer roll){
		
		if(map.containsKey(roll)) {
			Student student = map.get(roll);
			return new ResponseEntity<>(student,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
}
