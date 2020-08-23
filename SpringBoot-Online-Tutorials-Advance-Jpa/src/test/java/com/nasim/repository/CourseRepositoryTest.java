package com.nasim.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.nasim.SpringBootOnlineTutorialsAdvanceJpaApplication;
import com.nasim.model.Course;

@SpringBootTest(classes = SpringBootOnlineTutorialsAdvanceJpaApplication.class)
class CourseRepositoryTest {
	@Autowired
	private CourseRepository courseRepository;

	@Test
	void findById() {
		Course course=courseRepository.findById(2);
		assertEquals(2, course.getId());
	}
	
	@Test
	@DirtiesContext
	void deleteById() {
		courseRepository.deleteBYId(2);
		assertNull(courseRepository.findById(2));
	}
	
	@Test
	@DirtiesContext
	void SaveOrUpdate() {
		// find one row
		Course course=courseRepository.findById(2);
        assertEquals("Hibernate", course.getName());
        
		//update information
		course.setName("Hibernate is updated.");
		courseRepository.SaveOrUpdate(course);
		
		// check information
		Course course1=courseRepository.findById(2);
        assertEquals("Hibernate is updated.", course1.getName());
	}

}
