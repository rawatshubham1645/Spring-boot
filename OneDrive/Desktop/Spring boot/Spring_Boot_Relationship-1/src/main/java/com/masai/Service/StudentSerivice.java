package com.masai.Service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.masai.Exception.CourseException;
import com.masai.Exception.StudentException;
import com.masai.Model.Course;
import com.masai.Model.Student;


public interface StudentSerivice {
	public Student registerStudent(String cname, Student student)throws CourseException;
	
	public Set<Student> findStudentByCourseName(String course) throws CourseException;
}
