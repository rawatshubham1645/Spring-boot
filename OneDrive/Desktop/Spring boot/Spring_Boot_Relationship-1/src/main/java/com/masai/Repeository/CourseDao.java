package com.masai.Repeository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.Model.Course;
import com.masai.Model.Student;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer>{
	
	public Course findByCourseName(String courseName);
	
	//Same method with the help of JPQL
//	@Query("from Course where courseName = ?1")
//	public Course getCourseByName(String cname);
	
	@Query("select c.students from Course c where c.courseName =?1")
	public Set<Student> getStudentByCourseName(String cname);

}
