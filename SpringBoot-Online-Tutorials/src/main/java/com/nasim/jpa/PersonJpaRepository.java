package com.nasim.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonJpaRepository {
	@Autowired
	EntityManager entityManager;
	
	public List<Person>findAll(){
		TypedQuery<Person>query  =entityManager.createNamedQuery("Person.findAll",Person.class);
		List<Person> result=query.getResultList();
		return result;
	}
	
	public Person findBYId(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person SaveOrUpdate(Person person) {
		return entityManager.merge(person);
	}
	
	
	public void deleteBYId(int id) {
		Person person=findBYId(id);
		 entityManager.remove(person);
	}
}
