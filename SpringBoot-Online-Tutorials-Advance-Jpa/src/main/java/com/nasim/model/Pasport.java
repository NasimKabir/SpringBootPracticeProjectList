package com.nasim.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "pasport")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pasport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String number;
	
	
	public Pasport(String number) {
		super();
		this.number = number;
	}
	
	
	
	
	
}
