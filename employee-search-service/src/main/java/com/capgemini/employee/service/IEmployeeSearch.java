package com.capgemini.employee.service;

import java.util.List;

import com.capgemini.employee.entity.Employee;

public interface IEmployeeSearch {
	
	public Employee getEmployeeById(Integer id);
	public String addEmployee(Employee emp);
	public Employee updateEmployee(Employee emp);
	public String removeEmployeeById(Integer id);
	public List<Employee> getAllEmployee();

}
