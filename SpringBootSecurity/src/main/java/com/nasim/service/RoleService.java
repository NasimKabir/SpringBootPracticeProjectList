package com.nasim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasim.model.Role;
import com.nasim.model.User;
import com.nasim.repository.RoleRepository;
import com.nasim.repository.UserRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
		
		public List<Role>getList(){
			return roleRepository.findAll();
		}
		
		public Role saveRole(Role role) {
			return roleRepository.save(role);
		}
}
