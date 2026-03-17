package com.cdsc.spirngmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cdsc.spirngmvcdemo.model.User;

@Controller
public class LoginController {
	
	@GetMapping("/login") // /user/login
	public String getLogin() {
		
		return "LoginForm";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model) {
		
		if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
			
			  model.addAttribute("uname",user.getUsername());
			 return "Home";
		}
		
		model.addAttribute("message","user not found !!");
		return "LoginForm";
		
		//Profile 
	}

}
