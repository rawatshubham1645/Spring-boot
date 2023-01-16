package com.masai.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.Exception.StudentException;
import com.masai.app.Model.Student;
import com.masai.app.Model.StudentDTO;
import com.masai.app.Repository.StudentRepository;


@Service
public class studentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository sRepo;
	@Override
	public Student saveStudentDetails(Student student) {
		Student savedStudent = sRepo.save(student);
		return savedStudent;
	}
	@Override
	public Student getStudentByRoll(Integer roll) throws StudentException{
		
//		Optional<Student> opt =sRepo.findById(roll);
//		if(opt.isPresent()) {
//			Student student = opt.get();
//			return student;	
//		}
//		else throw new StudentException("Student does not Exist with roll : "+ roll);
		
	return sRepo.findById(roll).orElseThrow(()->new StudentException("Student does not Exist with roll : "+ roll));
		
	}
	
	
	public List<Student> getAllStudents()throws StudentException{
		List<Student> student = sRepo.findAll();
		if(student.size()==0) {
			throw new StudentException("Students does not Exist");
		}
		else return student;
		  
	}
	@Override
	public Student deleteStudentByRoll(Integer roll) throws StudentException {
		
		Optional<Student> opt = sRepo.findById(roll);
		
		if(opt.isPresent()) {
			Student deletedStudent = opt.get();
			sRepo.delete(deletedStudent);
			return deletedStudent;
		}else throw new StudentException("Student does not Exist with roll : "+ roll);
		
	}
	@Override
	public Student updateStudentDetail(Student student) throws StudentException {
		
		Optional<Student> opt =sRepo.findById(student.getRoll());
		if(opt.isPresent()) {
			Student updatedStudent = sRepo.save(student);
			return updatedStudent;
		}else throw new StudentException("Invalid student Detail");
	}
	@Override
	public Student updateStudentMarks(Integer roll, Integer graceMarks) throws StudentException {
		Optional<Student> opt =sRepo.findById(roll);
		if(opt.isPresent()) {
			Student updateMarks = opt.get();
			updateMarks.setMarks(updateMarks.getMarks()+graceMarks);
			 return sRepo.save(updateMarks);
		}else throw new StudentException("Invalid student Detail");
	}
	
	
	//------------------- Get Student By Marks ---------------------------------------------
	
	@Override
	public List<Student> getStudentByMarks(Integer marks) throws StudentException {
		
		
		List<Student> students = sRepo.findByMarks(marks);
		if(students.size()==0)throw new StudentException("No Student Fount of this Marks : "+marks);
		else return students;
	}

	
	//---- Get Student by Address ----------------------------------------
	
	@Override
	public Student getStudentByAddress(String address) throws StudentException {
		Student student = sRepo.findByAddress(address);
		if(student!=null)return student;
		else throw new StudentException("No Student Fount of this Address : "+address);
	}
	
	
	//---- Get Student Name by Roll----------------------------------------

	@Override
	public String getNameByRoll(Integer roll) throws StudentException {
		String name =sRepo.getStudentNameByRoll(roll);
		if(name!=null)return name;
		else throw new StudentException("No Student Found of this Roll : "+roll);
	}
	
	//---- Get Student Name And Marks by Address ----------------------------------------
	
	@Override
	public List<String> getNameAndMarks(String address) throws StudentException {
		List<String> list = sRepo.getNameAndMarksByAddress(address);
		if(list.size()!=0)return list;
		else throw new StudentException("No Student Found of this Address : "+address);
	}
	
	
	//---- Get Student Name And Marks by StudentDTO  ----------------------------------------
	@Override
	public List<StudentDTO> getNameAndMarks2(String address) throws StudentException {
		List<StudentDTO> list = sRepo.getNameAndMarksByAddress2(address);
		if(list.size()!=0)return list;
		else throw new StudentException("No Student Found of this Address : "+address);
	}
	
	
	
}
