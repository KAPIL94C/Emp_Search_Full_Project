package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.demo.EmployeeInfo;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class EmployeeClientController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/findAll")
	public List<EmployeeInfo> getemployeeAll() 
   { 
		String url="http://EMPLOLYEE-SEARCH:8081/employee/findAll/";
		
		ResponseEntity<EmployeeInfo[]> response = restTemplate.getForEntity(url, EmployeeInfo[].class);
		System.out.println(response);
		return Arrays.asList(response.getBody());
		

		} 
	
	
	@GetMapping("/{id}")
	public EmployeeInfo getemployeeRecord(@PathVariable int id)
   { 
		String url="http://EMPLOYEE-SEARCH:8081/employee/find/"+id;

		return restTemplate.getForObject(url, EmployeeInfo.class);
		} 
	
	@PostMapping("/addEmployee") 
	public String addemployeeRecord(@RequestBody EmployeeInfo emp) {
		
	
		String url="http://EMPLOYEE-SEARCH:8081/addEmployee/";
		return restTemplate.postForObject(url, emp, String.class); 
		
	}
	
	@PutMapping("/{id}") 
	public void updateemployee(@RequestBody EmployeeInfo emp, @PathVariable int id) {
		
	
		String url="http://EMPLOYEE-SEARCH:8081/employee/update/"+id;
		       restTemplate.put(url, emp);
		
	}
	
	@DeleteMapping("/{id}") 
	public void deleteemployeeRecord(@PathVariable int id) {
		
		System.out.println("in delete method");
		String url="http://EMPLOYEE-SEARCH:8081/employee/delete/"+id;
		System.out.println("in delete method"+url);
		restTemplate.delete(url);
		
	}
	
	
	}
