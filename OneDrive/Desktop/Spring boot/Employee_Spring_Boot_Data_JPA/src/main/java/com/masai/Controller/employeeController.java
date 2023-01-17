package com.masai.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.EmployeeException;
import com.masai.Model.Employee;
import com.masai.Model.EmployeeDTO;
import com.masai.Service.EmployeeService;



@RestController
public class employeeController {
	@Autowired
	private EmployeeService eService;
	
	//---------------For Register A Employee ---------------------------------
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> registerEmployeeHandler(@Valid @RequestBody Employee emp) throws EmployeeException {
		Employee employee =eService.registerEmployee(emp);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	
	//---------get Employee Details  By Employee Id ------------------------------------
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeByIdHandler(@Valid @PathVariable("id")Integer empId) throws EmployeeException{
		Employee emp = eService.getEmployeeById(empId);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		
	}
	
	//------------------------ List of Employee ----------------------------------------
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getListOfEmplHandler() throws EmployeeException{
		List<Employee> list = eService.getAllEmployeeDetails();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	//-----------------Delete Employee By Id ---------------------------------------
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deletedStudentHandler(@Valid @PathVariable("id") Integer empId) throws EmployeeException{
		
		Employee employee = eService.deleteEmployeeById(empId);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		
	}
	//------------------------ List of Employee By address----------------------------------------
		@GetMapping("/getEmployeeByAddress/{address}")
		public ResponseEntity<List<Employee>> getListOfEmplByAddressHandler(@Valid @PathVariable("address") String Address) throws EmployeeException{
			List<Employee> list = eService.getEmployeeDetailsByAddress(Address);
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		
		
		
		@GetMapping("/getNameAddressSalary")
		public ResponseEntity<List<EmployeeDTO>> getNameAddressSalaryHandler() throws EmployeeException{
			
			List<EmployeeDTO> list = eService.getNameAddressSalaryOfAllEmployee();
			return new ResponseEntity<List<EmployeeDTO>>(list,HttpStatus.OK);
		}
}
