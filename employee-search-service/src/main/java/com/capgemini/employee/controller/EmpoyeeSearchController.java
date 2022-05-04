package com.capgemini.employee.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.employee.entity.Employee;
import com.capgemini.employee.service.IEmployeeSearch;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class EmpoyeeSearchController {

	
	
	@Autowired
	IEmployeeSearch employeeSearch;
	
	
	@GetMapping("/employee/find/{id}")
	public Employee findById(@PathVariable Integer id)
	{
	return employeeSearch.getEmployeeById(id);
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public String deleteById(@PathVariable Integer id)
	{
	return employeeSearch.removeEmployeeById(id);
	}
	
	
	@GetMapping("/employee/findAll")
	public List<Employee> findById()
	{
	return employeeSearch.getAllEmployee();
	}
	
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee emp)
	{
	employeeSearch.addEmployee(emp);
	return "Employee Addedd Successfully";
	}
	
	   @PutMapping("/employee/update/{id}")
	  public Employee updateEmployee(@RequestBody Employee requestData, @PathVariable int id) {
		   requestData.setEid(id);
	    	  return   employeeSearch.updateEmployee(requestData);
	          
	    		
	    }


}
