package com.spring.assembler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.spring.dto.EmployeeDto;
import com.spring.model.Employee;
@Component
public class EmployeeControllerResourceAssembler implements RepresentationModelAssembler<Employee,EmployeeDto>{

	@Override
	public EmployeeDto toModel(Employee entity) {
		EmployeeDto employee=new EmployeeDto(entity.getId(),entity.getName(),entity.getEmail());
		//product.add(linkTo(methodOn(ProductController.class).getProduct(entity.getId())).withSelfRel());
		return employee;
	}

	@Override
	public CollectionModel<EmployeeDto> toCollectionModel(Iterable<? extends Employee> entities) {
		List<EmployeeDto> employeList=new ArrayList<>();
		for(Employee entity:entities) {
			employeList.addAll((Collection<? extends EmployeeDto>) entity);
		}
		return (CollectionModel<EmployeeDto>) employeList;
	}

	

}
