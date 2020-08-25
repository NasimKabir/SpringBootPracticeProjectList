package com.nasim.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nasim.model.Course;
import com.nasim.model.Review;
import com.nasim.model.Student;

@Repository
@Transactional
public class CourseRepository {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager entityManager;

	public Course findById(int id) {
		Course course = entityManager.find(Course.class, id);
		return course;
	}

	public void deleteBYId(int id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}

	public Course SaveOrUpdate(Course course) {
		if (course.getId() == 0) {
			entityManager.persist(course);
		} else {
			entityManager.merge(course);
		}
		return course;
	}

	// that's are not best practice
	public void HardCodedInsertCoursetoReview() {
		// get the courese
		Course course = findById(2);
		logger.info("Reviews {}", course.getReview());
		// add reviews
		Review review = new Review("5", "Nice Course");
		Review review1 = new Review("5", "Nice Course");

		// setting the relationship
		course.addReview(review);
		review.setCourse(course);

		course.addReview(review1);
		review1.setCourse(course);

		// saving database
		entityManager.persist(review);
		entityManager.persist(review1);
	}

	// that's are best practice
	public void InsertCoursetoReview(int id, List<Review> reviews) {
		Course course = findById(id);
		logger.info("Reviews {}", course.getReview());
		for (Review review : reviews) {
			course.addReview(review);
			review.setCourse(course);
			entityManager.persist(review);
		}

	}
	
	// that's are best practice
		public void InsertCourseandStudent(Student student, Course course) {
			student.addCourse(course);
			course.addStudent(student);
			entityManager.persist(course);
			entityManager.persist(student);
		}
}
