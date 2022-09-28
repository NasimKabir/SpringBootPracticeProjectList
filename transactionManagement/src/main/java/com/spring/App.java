package com.spring;

import com.spring.configuration.Config;
import com.spring.model.Employee;
import com.spring.service.EmployeeService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
// configurable
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.getBean("employeeService", EmployeeService.class).save();
        context.close();
    }
}
