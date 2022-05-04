package com.example.demo;

import java.util.List;

public class EmployeeDetailsResponse {

	   private List<EmployeeInfo> employees;
	   
	    public List<EmployeeInfo> getUsers() {
	        return employees;
	    }
	 
	    public void setUsers(List<EmployeeInfo> employees) {
	        this.employees = employees;
	    }
	 
	
}
