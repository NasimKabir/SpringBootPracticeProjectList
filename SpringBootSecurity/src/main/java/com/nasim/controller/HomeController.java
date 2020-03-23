package com.nasim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nasim.model.Role;
import com.nasim.model.User;
import com.nasim.service.RoleService;
import com.nasim.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	
	
	@GetMapping("/")
	public String HomePage(Model model) {
		
		
		List<User>getList=userService.getUserList();
		model.addAttribute("users", getList);
		return "home";

	}

	@GetMapping("/login")
	public String LoginPage() {
		return "login";

	}
@GetMapping("/create")
	public String createUser(Model model) {
	List<Role>getroleList=roleService.getList();
	model.addAttribute("roles", getroleList);
	
		model.addAttribute("user", new User());
		return "createuser";
	}

	@PostMapping("/save")
	public String SaveUser(User user) {
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.saveUser(user);
		return "redirect:/";

	}
	
	
	@GetMapping("/createRole")
	public String createrole(Model model) {
		model.addAttribute("role", new Role());
		return "createrole";
	}

	@PostMapping("/saveRole")
	public String SaveROle(Role role) {
		roleService.saveRole(role);
		return "redirect:/";

	}

}
