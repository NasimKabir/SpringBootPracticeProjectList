package com.nasim.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "course")
	private List<Review>review=new ArrayList<>();
	
	@ManyToMany(mappedBy = "course")
	private List<Student>student=new ArrayList<>();
	
	public Course(String name) {
		super();
		this.name = name;
	}
	
	public void addReview(Review review) {
		this.review.add(review);
		}
	
	public void removeReview(Review review) {
		this.review.remove(review);
		}

	public void addStudent(Student student) {
		this.student.add(student);
		}
	public void removeStudent(Student student) {
		this.student.remove(student);
		}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", review=" + review + ", student=" + student + "]";
	}
	
	
	
	
}
