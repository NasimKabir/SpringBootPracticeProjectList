package com.nasim.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nasim.exception.Response;
import com.nasim.exception.ResponseBuilder;
import com.nasim.model.Role;
import com.nasim.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository repository;
	
	public Response createRole(Role role) {
		if(role==null) {
			return ResponseBuilder.getFailureResponse(HttpStatus.BAD_REQUEST, "Role name is incorrect.");
		}
		role=repository.save(role);
		return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "Role creation Success", role);

	}

}
