package com.cdsc.spirngmvcdemo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdsc.spirngmvcdemo.model.User;
import com.cdsc.spirngmvcdemo.repository.UserRepository;
import com.cdsc.spirngmvcdemo.service.UserService;

@Controller
public class SignupController {
	
	@Autowired
	private UserRepository  userRepo;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/signup")
	public String getSignup() {
		
		return "SignupForm";
	}
	
//	@PostMapping("/signup")
//	public String postSignup(@ModelAttribute User user, Model model, 
//								@RequestParam("gender") String gender,
//								@RequestParam("country") String country,
//								@RequestParam("hobby") String hobby,
//								@RequestParam("gender") String message,
//								@RequestParam("dob") LocalDate dob,
//								@RequestParam("officeTime") LocalTime officeTime) {
//		
//		model.addAttribute("user",user);
//		model.addAttribute("gender",gender);
//		model.addAttribute("hobby",hobby);
//		model.addAttribute("dob",dob);
//		
//		//send user list 
//		model.addAttribute("userList",List.of(user,user,user,user,user,user,user,user,user,user,user,user));
//		
//		
//		return "Profile";
//	}

	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user, Model model) {
		
		//send user data in db
		userService.userSignup(user);
		
		return "LoginForm";
	}
	
	/*
	 * --------- How to connect database in spring boot project ------------
	 *   a. put dependency of "Spring Data JPA"
	 *   b. put dependency of "JDBC Driver"(Mysql)
	 */

}
