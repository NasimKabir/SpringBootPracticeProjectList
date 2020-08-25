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

import com.nasim.AdvanceJpaApplication;
import com.nasim.model.Course;
import com.nasim.model.Pasport;
import com.nasim.model.Student;

@SpringBootTest(classes = AdvanceJpaApplication.class)
class StudentRepositoryTest {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager entity;

	@Test
	@Transactional
	void findStudentInformation() {
		Student student=entity.find(Student.class, 2);
		logger.info("Student info {}", student);
		logger.info("Pasport info {}", student.getPasport());

	}
	
	@Test
	@Transactional
	void findStudentAndCourse() {
		Student student=entity.find(Student.class, 2);
		logger.info("Student info {}", student);
		logger.info("Course info {}", student.getCourse());

	}

	@Test
	@Transactional
	void findByPasportInformation() {
		Pasport pasport=entity.find(Pasport.class, 2);
		logger.info("Pasport info {}", pasport);
		logger.info("Student info {}", pasport.getStudent());

	}
	
	
	@Test
	@Transactional
	void SomeMethod() {
		// retrive students
		Student student=entity.find(Student.class, 2);
		
		//retive passport
		Pasport pasprot=student.getPasport();

		// update students
		student.setName("Nasim Kabir");
		
		// update passport
		pasprot.setNumber("D5268755");

	}
	
}
