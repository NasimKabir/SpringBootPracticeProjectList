package com.nasim.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class FulltimeEmployee extends Employee {
	private BigDecimal salary;

	public FulltimeEmployee() {
	
	}

	public FulltimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
	}

}
