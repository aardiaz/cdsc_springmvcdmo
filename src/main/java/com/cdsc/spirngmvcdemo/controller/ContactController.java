package com.cdsc.spirngmvcdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdsc.spirngmvcdemo.utils.MyEmail;

@Controller
public class ContactController {
	
	@Autowired
	private MyEmail myEmail;
	
	@GetMapping("/contact")
	public String getContact() {
		
		return "ContactForm";
	}

	@PostMapping("/contact")
	public String postContact( Model model,@RequestParam("toEmail") String toEmail,@RequestParam("subject") String subject,@RequestParam("message") String message) {
		
		myEmail.sendEmail(toEmail, subject, message);
		model.addAttribute("message","Email sent successfully to : "+toEmail);
		
		return "ContactForm";
	}
}
