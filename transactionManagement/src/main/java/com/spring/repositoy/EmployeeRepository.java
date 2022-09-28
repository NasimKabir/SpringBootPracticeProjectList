package com.spring.repositoy;

import com.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeRepository {
    // jdbc template
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // save employee
    @Transactional
    public int save(Employee employee) {
        // insert query
        String query = "insert into Employee values(?,?,?)";
        Object[] args = {employee.getId(), employee.getName(), employee.getCity()};
        return jdbcTemplate.update(query, args);
    }
}
