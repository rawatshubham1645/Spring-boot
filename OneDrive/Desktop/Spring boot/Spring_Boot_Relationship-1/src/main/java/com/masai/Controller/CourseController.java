package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.CourseException;
import com.masai.Model.Course;
import com.masai.Service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService cService;
	/*
	 * 
	 * {
    "courseName":"java",
    "fee":1000,
    "students":[
        {
            "name":"shubham",
            "marks":89,
            "addr":{
                "state":"MH",
                "city":"Pune",
                "pincode":"21455"
            }
        },
         {
            "name":"Sourabh",
            "marks":89,
            "addr":{
                "state":"Up",
                "city":"Delhi",
                "pincode":"21455"
            }
        }
    ]
}
	 */
	@PostMapping("/courses")
	public ResponseEntity<Course>  saveCourse(@RequestBody Course course) throws CourseException {
		Course courses =cService.registerCourse(course);
		return new ResponseEntity<Course>(courses,HttpStatus.ACCEPTED);
	}
}
