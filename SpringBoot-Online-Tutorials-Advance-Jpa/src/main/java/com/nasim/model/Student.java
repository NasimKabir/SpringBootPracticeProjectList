package com.nasim.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	private Pasport pasport;

	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE", 
	joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	private List<Course> course = new ArrayList<>();

	public void addCourse(Course course) {
		this.course.add(course);
	}

	public void removeCourse(Course course) {
		this.course.remove(course);
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student id=" + id + ", name=" + name;
	}

}
