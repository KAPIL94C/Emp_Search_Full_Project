package com.capgemini.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.employee.Exception.EmployeeNotFoundException;
import com.capgemini.employee.dao.EmployeeRepository;
import com.capgemini.employee.entity.Employee;

@Service
public class EmployeeSearchImpl  implements IEmployeeSearch {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee getEmployeeById(Integer id) {
	
	return employeeRepository.findById(id).get();
	}
	
	
	@Override
	public String addEmployee(Employee emp) {
	
	employeeRepository.save(emp);
	return "New Employee Added";
	}
	
	
	@Override
	public Employee updateEmployee(Employee emp) {

	
	boolean exists =employeeRepository.existsById(emp.getEid());
	if(!exists) {
		 throw new EmployeeNotFoundException("Employee  not found for id=" + emp.getEid());
	}
	emp = employeeRepository.save(emp);
    return emp;
	}
	
	
	@Override
	public String removeEmployeeById(Integer id) {
	
	employeeRepository.deleteById(id);
	return "Employee with Id"+id+"deleted";
	}
	
	
	@Override
	public List<Employee> getAllEmployee() {
	
	return employeeRepository.findAll();
	}
	
	

}
