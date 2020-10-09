package com.nasim.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nasim.exception.Response;
import com.nasim.exception.ResponseBuilder;
import com.nasim.model.Role;
import com.nasim.security.RoleService;

@RestController
public class RoleController {
	@Autowired
	private RoleService roleService;

	@PostMapping("/role")
	public Response RoleCreate(@Valid @RequestBody Role role, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseBuilder.getFailureResponse(HttpStatus.BAD_REQUEST, "Role name is incorrect.");

		}
		return roleService.createRole(role);
	}
}
