package com.masai.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.app.Model.Student;
import com.masai.app.Model.StudentDTO;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
	
	public List<Student> findByMarks(Integer marks);
	
	
	public Student findByAddress(String address);
	
	@Query("select name from Student where roll = :r")
	public String getStudentNameByRoll(@Param("r") Integer roll);
	
	@Query("select name, marks from Student where address =?1")
	public List<String> getNameAndMarksByAddress(String address);
	
	//If We have to Partially fetch the data  we can use DTO 
	@Query("select new com.masai.app.Model.StudentDTO (name,marks) from Student where address =?1")
	public List<StudentDTO> getNameAndMarksByAddress2(String address);
}
