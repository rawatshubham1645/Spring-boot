package com.masai.Repeository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.masai.Model.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer>{
	
	public Course findByCourseName(String courseName);
	
	//Same method with the help of JPQL
//	@Query("from Course where courseName = ?1")
//	public Course getCourseByName(String cname);

}
