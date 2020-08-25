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
import com.nasim.model.Review;

@SpringBootTest(classes = AdvanceJpaApplication.class)
class CourseRepositoryTest {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	EntityManager em;

	@Test
	void findById() {
		Course course=courseRepository.findById(5);
		assertEquals(5, course.getId());
	}
	
//	@Test
//	@DirtiesContext
//	void deleteById() {
//		courseRepository.deleteBYId(5);
//		assertNull(courseRepository.findById(5));
//	}
	
	@Test
	@DirtiesContext
	void SaveOrUpdate() {
		// find one row
		Course course=courseRepository.findById(5);
        assertEquals("Spring boot", course.getName());
        
		//update information
		course.setName("Hibernate is updated.");
		courseRepository.SaveOrUpdate(course);
		
		// check information
		Course course1=courseRepository.findById(5);
        assertEquals("Hibernate is updated.", course1.getName());
	}
	
	
	
	@Test
	@DirtiesContext
	@Transactional
	void retirveCourseFromReview() {
		Course course=courseRepository.findById(2);
		logger.info("Review information {}", course.getReview());
	}

	@Test
	@Transactional
	@DirtiesContext
	void retirveReviewFromCourse() {
		Review review=em.find(Review.class, 5);
		logger.info("Course information {}",review.getCourse());
	}
}
