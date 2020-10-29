package com.spring.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.spring.dao.StudentDao;
import com.spring.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	private String key = "student";
	@Resource(name = "redisTemplate")
	private HashOperations<String, Integer, Student> operation;

	@Override
	public void addStudent(Student s) {
		operation.putIfAbsent(key, s.getId(), s);
	}

	@Override
	public void updateStudent(Student s) {
		operation.put(key, s.getId(), s);

	}

	@Override
	public Student getOneStudentInfo(int id) {
		return operation.get(key, id);
	}

	@Override
	public void moveStudent(int id) {

		operation.delete(key, id);
	}

	@Override
	public Map<Integer, Student> getAllStudent() {

		return operation.entries(key);
	}

}
