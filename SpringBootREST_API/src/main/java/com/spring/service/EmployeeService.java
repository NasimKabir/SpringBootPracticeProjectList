package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Employee;
import com.spring.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
private EmployeeRepository employeeRepository;
	
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee>getEmployee(Employee employee){
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> getEmployeeId(int id) {
		return employeeRepository.findById(id);
	}
	
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}
}
