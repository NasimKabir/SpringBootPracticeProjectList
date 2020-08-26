package com.nasim.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nasim.model.Course;
import com.nasim.model.Employee;
import com.nasim.model.FulltimeEmployee;
import com.nasim.model.PartimeEmployee;
import com.nasim.model.Review;
import com.nasim.model.Student;

@Repository
@Transactional
public class EmployeeRepository {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager entityManager;

	// insert imployee
	public void SaveEmployee(Employee employee) {
		entityManager.persist(employee);
	}

	// retrive employee information
	public List<PartimeEmployee> retrivePartimeEmployeeInformation() {
		return entityManager.createQuery("select e from PartimeEmployee e", PartimeEmployee.class).getResultList();
	}
	
		public List<FulltimeEmployee> retriveFulltimeEmployeeInformation() {
			return entityManager.createQuery("select e from FulltimeEmployee e", FulltimeEmployee.class).getResultList();
		}

}
