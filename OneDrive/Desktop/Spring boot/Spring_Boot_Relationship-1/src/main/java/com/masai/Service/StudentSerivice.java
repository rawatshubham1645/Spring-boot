package com.masai.Service;

import org.springframework.stereotype.Service;

import com.masai.Exception.CourseException;
import com.masai.Exception.StudentException;
import com.masai.Model.Student;


public interface StudentSerivice {
	public Student registerStudent(String cname, Student student)throws CourseException;
}
