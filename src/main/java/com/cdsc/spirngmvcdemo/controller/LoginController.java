package com.cdsc.spirngmvcdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cdsc.spirngmvcdemo.model.User;
import com.cdsc.spirngmvcdemo.repository.UserRepository;
import com.cdsc.spirngmvcdemo.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;
	
	@GetMapping({"/login","/"}) // /user/login
	public String getLogin() {
		
		return "LoginForm";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model) {
		
		
		User usr = userService.userLogin(user.getUsername(), user.getPassword());
		
		if (usr != null) {
			
			  model.addAttribute("uname",user.getUsername());
			 return "Home";
		}
		
		model.addAttribute("message","user not found !!");
		return "LoginForm";
		
	}
	
	@GetMapping("/logout")
	public  String  logout() {
		
		return "LoginForm";
	}
	

}
