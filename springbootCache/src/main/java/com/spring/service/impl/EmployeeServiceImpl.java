package com.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.spring.model.Employee;
import com.spring.repository.EmployeeRepository;
import com.spring.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee e) {
		return employeeRepository.save(e);
	}
	@CachePut(value = "employee",key ="#id" )
	@Override
	public Employee updateEmployee(int id, Employee e) {
		Employee emp = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		emp.setName(e.getName());
		emp.setSalary(e.getSalary());
		return employeeRepository.save(emp);
	}
	@CacheEvict(value = "employee",allEntries = true)
	@Override
	public Employee getOneEmployeeInfo(int id) {
		Employee empId = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		return empId;
	}
	@Cacheable(value = "employee",key ="#id" )
	@Override
	public void deleteEmployee(int id) {
		Employee empId = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		employeeRepository.delete(empId);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

}
