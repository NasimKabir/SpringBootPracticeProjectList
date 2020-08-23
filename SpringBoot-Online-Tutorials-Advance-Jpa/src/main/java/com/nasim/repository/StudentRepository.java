package com.nasim.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nasim.model.Pasport;
import com.nasim.model.Student;

@Repository
@Transactional
public class StudentRepository {
	@Autowired
	private EntityManager entityManager;
	
	public Student findById(int id) {
		Student student= entityManager.find(Student.class, id);
		return student;
	}
	
	public void deleteBYId(int id) {
	Student student=entityManager.find(Student.class, id);
		entityManager.remove(student);
	}
	
	public Student SaveOrUpdate(Student student) {
		if(student.getId() == 0) {
			entityManager.persist(student);
		}else {
			entityManager.merge(student);
		}
		return student;
	}
	
	public Student SaveStudentWithPasport() {
		Pasport pasport=new Pasport("E0225476");
		entityManager.persist(pasport);
		
		Student student=new Student("Jani nah");
		student.setPasport(pasport);
		entityManager.persist(student);
		return student;
	}
}
