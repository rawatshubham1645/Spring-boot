package com.masai.Service;

import com.masai.Exception.CourseException;
import com.masai.Model.Course;

public interface CourseService {
	
	public Course registerCourse(Course course)throws CourseException;
}
