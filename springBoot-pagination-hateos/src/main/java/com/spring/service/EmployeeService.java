package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.model.Employee;
import com.spring.repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Page<Employee> getAllEmployeeInfo(Pageable pageRequest) {
		return employeeRepository.findAll(pageRequest);
	}
}
