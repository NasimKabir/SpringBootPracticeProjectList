package com.nasim.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String rating;
	private String description;
	// **ToOne fech always eager
	// **ToMany fech always lazy
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Course course;
	
	public Review(String rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", description=" + description ;
	}
	
	
	
	
	
}
