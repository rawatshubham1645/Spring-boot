package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.diagnostics.FailureAnalysisReporter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masai.Exception.EmployeeException;
import com.masai.Model.Employee;
import com.masai.Model.EmployeeDTO;
import com.masai.Repository.EmployeeRepo;


@Service
public class EmployeeServiceImpl implements EmployeeService{
		
	@Autowired
	private EmployeeRepo eRepo;
	@Override
	public Employee registerEmployee(Employee emp) throws EmployeeException {
		Employee employee = eRepo.save(emp);
		if(employee!=null)return employee;
		else throw new EmployeeException("Student Not Saved......");
	}

	@Override
	public Employee getEmployeeById(Integer empId) throws EmployeeException {
		
		Optional<Employee> opt =eRepo.findById(empId);
		if(opt.isPresent()) {
			Employee employee = opt.get();
			return employee;
		}else throw new EmployeeException("Employee Not Found By this id : "+ empId);
	}

	@Override
	public List<Employee> getAllEmployeeDetails() throws EmployeeException {
		List<Employee> list =eRepo.findAll();
		if(list.size()!=0)return list;
		else throw new EmployeeException("No Employee Is There");
	}

	@Override
	public Employee deleteEmployeeById(Integer empId) throws EmployeeException {
		Optional<Employee> opt =eRepo.findById(empId);
		if(opt.isPresent()) {
			Employee employee = opt.get();
			eRepo.delete(employee);
			return employee;
		}else throw new EmployeeException("Employee Not Found By this id : "+ empId);
	}

	@Override
	public Employee loginEmployee(String email, String password) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeeDetailsByAddress(String address) throws EmployeeException {
		List<Employee> list = eRepo.getEmployeeByAddress(address);
		if(list.size()!=0) return list;
		else throw new EmployeeException("Employee Not Found By this Address : "+ address);
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameAndAddressOfEmplyeeById(Integer empId) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee() throws EmployeeException {
		List<EmployeeDTO> list = eRepo.getNameAddressSalary();
		if(list.size()!=0)return list;
		else throw new EmployeeException("No Student Found ");
	}

}
