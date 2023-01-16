package com.masai.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.Model.Student;
@Repository
public interface StudentRep extends JpaRepository<Student, Integer>{

}
