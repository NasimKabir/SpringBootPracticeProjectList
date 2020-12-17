package com.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.assembler.EmployeeControllerResourceAssembler;
import com.spring.converter.ConverterService;
import com.spring.dto.EmployeeDto;
import com.spring.model.Employee;
import com.spring.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ConverterService converterService;

	@Autowired
	private EmployeeControllerResourceAssembler userControllerResourceAssembler;

	@GetMapping("/")
	public ResponseEntity<PagedResourcesAssembler<EmployeeDto>> getUserinfo(@PageableDefault(page = 0, size = 4) Pageable pageRequest,PagedResourcesAssembler<EmployeeDto> pagedResourcAssembler) {

		Page<Employee> userPage = employeeService.getAllEmployeeInfo(pageRequest);
		List<Employee> userResultList = userPage.getContent();
		List<EmployeeDto> userDtoList = userResultList.stream().map(converterService::convertToDto)
				.collect(Collectors.toList());
		Page<EmployeeDto> userDtoPage = new PageImpl<>(userDtoList, pageRequest, userPage.getTotalElements());
		PagedModel<EntityModel<EmployeeDto>> resource = pagedResourcAssembler.toModel(userDtoPage);
		return new ResponseEntity(resource, HttpStatus.OK);
	}
}
