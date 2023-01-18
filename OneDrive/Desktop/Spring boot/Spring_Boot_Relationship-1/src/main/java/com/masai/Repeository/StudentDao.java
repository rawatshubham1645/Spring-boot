package com.masai.Repeository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.Model.Course;
import com.masai.Model.Student;


@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{


}
