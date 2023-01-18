package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CourseException;

import com.masai.Model.Course;
import com.masai.Model.Student;
import com.masai.Repeository.CourseDao;
import com.masai.Repeository.StudentDao;

@Service
public class StudentServiceImpl implements StudentSerivice{
	
	
	@Autowired
	private StudentDao sDao;
	@Autowired
	private CourseDao cDao;
	@Override
	public Student registerStudent(String cname, Student student) throws CourseException {
		Course courses = cDao.findByCourseName(cname);
		if(courses!=null) {
			courses.getStudents().add(student);
			student.getCourse().add(courses);
			return sDao.save(student);
		}else throw new CourseException("Course Is not Found by This provided Name"+cname);
		
	}

}
