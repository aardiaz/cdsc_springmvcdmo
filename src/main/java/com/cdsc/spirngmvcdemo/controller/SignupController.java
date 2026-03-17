package com.cdsc.spirngmvcdemo.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdsc.spirngmvcdemo.model.User;

@Controller
public class SignupController {
	
	@GetMapping("/signup")
	public String getSignup() {
		
		return "SignupForm";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user, Model model, 
								@RequestParam("gender") String gender,
								@RequestParam("country") String country,
								@RequestParam("hobby") String hobby,
								@RequestParam("gender") String message,
								@RequestParam("dob") LocalDate dob,
								@RequestParam("officeTime") LocalTime officeTime) {
		
		model.addAttribute("user",user);
		model.addAttribute("gender",gender);
		model.addAttribute("hobby",hobby);
		model.addAttribute("dob",dob);
		
		
		
		return "Profile";
	}

}
