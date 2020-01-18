package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Employee;
import com.spring.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PutMapping("/employee")
	public Employee SaveEmployee(@RequestBody Employee employee) {
		Employee empl=employeeService.saveEmployee(employee);
       return empl;
	}
	@GetMapping("/employee")
	public List<Employee>getEmployeeList(Employee employee){
		List<Employee>emp=employeeService.getEmployee(employee);
		return emp;
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeid(@PathVariable int id) {
		Employee emp=employeeService.getEmployeeId(id).get();
		return emp;
	}
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}
}
