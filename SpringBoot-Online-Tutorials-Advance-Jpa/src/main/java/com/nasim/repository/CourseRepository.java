package com.nasim.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nasim.model.Course;

@Repository
@Transactional
public class CourseRepository {
	@Autowired
	private EntityManager entityManager;
	
	public Course findById(int id) {
		Course course= entityManager.find(Course.class, id);
		return course;
	}
	
	public void deleteBYId(int id) {
	Course course=entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
	
	public Course SaveOrUpdate(Course course) {
		if(course.getId() == 0) {
			entityManager.persist(course);
		}else {
			entityManager.merge(course);
		}
		return course;
	}
}
