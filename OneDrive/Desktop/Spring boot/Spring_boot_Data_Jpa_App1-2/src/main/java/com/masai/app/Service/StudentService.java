package com.masai.app.Service;

import java.util.List;

import com.masai.app.Exception.StudentException;
import com.masai.app.Model.Student;
import com.masai.app.Model.StudentDTO;

public interface StudentService {
	
	
	//this method will take a student obj without roll 
	// and return the saved student object with auto-generated roll 
	public Student saveStudentDetails(Student student);
	
	public Student getStudentByRoll(Integer roll)throws StudentException;
	
	public List<Student> getAllStudents() throws StudentException;
	
	
	public Student deleteStudentByRoll(Integer roll) throws StudentException;
	
	
	public Student updateStudentDetail(Student student)throws StudentException;
	
	public Student updateStudentMarks(Integer roll,Integer graceMarks) throws StudentException;
	
	//---- Get List of Student By Marks(Non-Primary Key)  -----------------------
	public List<Student> getStudentByMarks(Integer marks) throws StudentException;
	
	//---- Get Student by Address ----------------------------------------
	public Student getStudentByAddress(String address) throws StudentException;
	
	//---- Get Student Name by Roll----------------------------------------
	public String getNameByRoll(Integer roll) throws StudentException;
	
	//---- Get Student Name And Marks by Address ----------------------------------------
	public List<String> getNameAndMarks(String address) throws StudentException;
	
	//If We have to Partially fetch the data  we can use DTO 
	public List<StudentDTO> getNameAndMarks2(String address) throws StudentException;
}
