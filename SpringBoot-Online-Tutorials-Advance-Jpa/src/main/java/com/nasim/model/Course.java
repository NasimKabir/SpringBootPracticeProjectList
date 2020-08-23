package com.nasim.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	
	public Course(String name) {
		super();
		this.name = name;
	}
	
	
	
}
