package com.nasim.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class PartimeEmployee extends Employee {
	private BigDecimal hourlyWase;

	public PartimeEmployee() {
		
	}

	public PartimeEmployee(String name, BigDecimal hourlyWase) {
		super(name);
		this.hourlyWase = hourlyWase;
	}

}
