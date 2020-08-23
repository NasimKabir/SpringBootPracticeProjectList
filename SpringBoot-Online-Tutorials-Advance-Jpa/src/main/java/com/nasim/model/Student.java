package com.nasim.model;

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
	
	public Student(String name) {
		super();
		this.name = name;
	}
	
	
	
}
