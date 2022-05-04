package com.capgemini.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.employee.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
