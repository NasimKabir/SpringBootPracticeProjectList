package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Employee;
import com.spring.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<?> saveEmployee(@RequestBody Employee e) {
		employeeService.saveEmployee(e);
		return ResponseEntity.ok("User registered successfully!");
	}

	@GetMapping
	public ResponseEntity<List<Employee>> allEmployee() {
		List<Employee> emp = employeeService.getAllEmployee();
		return ResponseEntity.ok(emp);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getOneEmployee(@PathVariable int id) {
		Employee emp = employeeService.getOneEmployeeInfo(id);
		return ResponseEntity.ok(emp);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Employee e) {
		employeeService.updateEmployee(id, e);
		return ResponseEntity.ok("Update successfull!");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOneEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Employee delete successfull");
	}
}
