package com.spring.service;

import com.spring.model.Employee;
import com.spring.repositoy.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // save employee
    @Transactional
    public void save() {
        // insert employee multiple times
        for(int i = 1; i <= 10; i++) {
            Employee emp = new Employee();
            emp.setId(i);
            emp.setName("Name " + i);
            emp.setCity("City " + i);
            if(i==5){
                throw new RuntimeException("Exception");
            }
            employeeRepository.save(emp);
        }
    }
}
