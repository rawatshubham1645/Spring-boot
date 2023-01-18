package com.masai.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CourseException;
import com.masai.Model.Course;
import com.masai.Model.Student;
import com.masai.Repeository.CourseDao;

@Service
public class CourseSerivceImpl implements CourseService{

	
	@Autowired
	private CourseDao cDao;
	
	@Override
	public Course registerCourse(Course course) throws CourseException {
		
		Set<Student> student=course.getStudents();
		for(Student students:student) {
			//Associating Each Student with course
			students.getCourse().add(course);
		}
		Course courses =cDao.save(course);
		if(courses!=null)return courses;
		else throw new CourseException("Course Unable to Created");
	}

}
