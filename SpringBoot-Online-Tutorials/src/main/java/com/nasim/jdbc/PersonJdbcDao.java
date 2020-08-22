package com.nasim.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nasim.model.Person;

@Repository
public class PersonJdbcDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {
		return jdbcTemplate.query("SELECT * FROM PERSON ", new BeanPropertyRowMapper<Person>(Person.class));
	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM PERSON where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete FROM PERSON where id=?", new Object[] { id });
	}

	public int insert(Person person) {
		return jdbcTemplate.update("insert into person(id,name,location,birth_date) values(?,?,?,?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirth_date().getTime()) });
	}

	public int update(Person person) {
		return jdbcTemplate.update("update person" + " set name=? , location=? , birth_date=? " + "where id=?",
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirth_date().getTime()),
						person.getId() });
	}
}
