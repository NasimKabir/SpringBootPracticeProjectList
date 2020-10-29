package com.spring.radis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.dao.StudentDao;
import com.spring.dao.impl.StudentDaoImpl;
import com.spring.model.Student;

@Component
public class RadisTest implements CommandLineRunner {
	@Autowired
	private StudentDao student;

	@Override
	public void run(String... args) throws Exception {
		student.addStudent(new Student(1,"a"));
		student.addStudent(new Student(2,"aa"));
		student.addStudent(new Student(3,"aaa"));
		
		student.updateStudent(new Student(3,"aaa3"));
		student.getAllStudent().forEach((k,v)->{System.out.println(k+" = "+v);});
	}

}
