package com.nasim.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.nasim.SpringBootOnlineTutorialsAdvanceJpaApplication;
import com.nasim.model.Course;
import com.nasim.model.Student;

@SpringBootTest(classes = SpringBootOnlineTutorialsAdvanceJpaApplication.class)
class StudentRepositoryTest {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager entity;

	@Test
	@Transactional
	void findById() {
		Student student=entity.find(Student.class, 2);
		logger.info("Student info {}", student);
		logger.info("Pasport info {}", student.getPasport());

	}
	
	
}
