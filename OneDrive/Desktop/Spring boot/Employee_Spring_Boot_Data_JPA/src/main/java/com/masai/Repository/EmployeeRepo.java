package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.Model.Employee;
import com.masai.Model.EmployeeDTO;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	public List<Employee> getEmployeeByAddress(String address);
	
	@Query("select new com.masai.Model.EmployeeDTO (e.empName,e.address,e.salary) from Employee e")
	public List<EmployeeDTO> getNameAddressSalary();
	
}
