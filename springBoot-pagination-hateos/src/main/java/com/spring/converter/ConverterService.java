package com.spring.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.dto.EmployeeDto;
import com.spring.model.Employee;


@Component
public class ConverterService {
	@Autowired
	private ModelMapper modelMapper;

// convert entity to dto	
	public EmployeeDto convertToDto(Employee employee) {
		return modelMapper.map(employee, EmployeeDto.class);
	}

}
