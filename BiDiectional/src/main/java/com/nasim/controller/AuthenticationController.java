package com.nasim.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nasim.exception.Response;
import com.nasim.model.LoginRequest;
import com.nasim.model.User;
import com.nasim.service.AuthenticationService;

@RestController
public class AuthenticationController {
	@Autowired
	private AuthenticationService authenticationService;
	
	  @PostMapping("/login")
	    public Response login(@RequestBody LoginRequest login, HttpServletRequest request, HttpServletResponse response){
	        return authenticationService.login(login);
	    }
	  
	  @PostMapping("/signup")
	    public Response Register(@Valid @RequestBody User user, HttpServletRequest request, HttpServletResponse response){
	        return authenticationService.registerUser(user);
	    }
  
}
