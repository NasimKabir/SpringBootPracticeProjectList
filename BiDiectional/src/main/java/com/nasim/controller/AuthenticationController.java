package com.nasim.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nasim.annotation.Validated;
import com.nasim.dto.LoginRequestDto;
import com.nasim.dto.UserDto;
import com.nasim.exception.Response;
import com.nasim.service.AuthenticationService;

@RestController
public class AuthenticationController {
	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/login")
	@Validated
	public Response login(@RequestBody LoginRequestDto login, HttpServletRequest request,
			HttpServletResponse response,BindingResult result) {
		return authenticationService.login(login);
	}

	@Validated
	@PostMapping("/signup")
	public Response Register(@RequestBody UserDto signUpRequest, HttpServletRequest request,
			HttpServletResponse response,BindingResult result) {
		return authenticationService.registerUser(signUpRequest);
	}

}
