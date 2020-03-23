package com.nasim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasim.model.User;
import com.nasim.repository.UserRepository;

@Service
public class UserService {
	@Autowired
private UserRepository userRepository;
	
	public List<User>getUserList(){
		return userRepository.findAll();
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
}
