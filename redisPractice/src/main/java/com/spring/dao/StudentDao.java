package com.spring.dao;

import java.util.Map;

import com.spring.model.Student;

public interface StudentDao {
void addStudent(Student s);
void updateStudent(Student s);
Student getOneStudentInfo(int id);
void moveStudent(int id);
Map<Integer,Student>getAllStudent();
}
