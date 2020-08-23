package com.nasim.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "rating")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String rating;
	private String description;
	
	
	public Rating(String rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}
	
	
	
	
	
}
