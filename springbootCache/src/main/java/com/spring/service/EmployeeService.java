package com.spring.service;

import java.util.List;

import com.spring.model.Employee;

public interface EmployeeService {
public Employee saveEmployee(Employee e);
public Employee updateEmployee(int id,Employee e);
public Employee getOneEmployeeInfo(int id);
public void deleteEmployee(int id);
public List<Employee>getAllEmployee();
}
