package com.spring.dto;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto extends RepresentationModel<EmployeeDto> {
	@JsonProperty(value = "Id")
	private int id;
	@JsonProperty(value = "Name")
	private String name;
	@JsonProperty(value = "Email")
	private String email;
}
