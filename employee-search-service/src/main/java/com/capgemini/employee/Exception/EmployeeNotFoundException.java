package com.capgemini.employee.Exception;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(String msg) {
		super(msg);
	}

}
