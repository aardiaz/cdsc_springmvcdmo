package com.cdsc.spirngmvcdemo.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class GalleryController {
	
	@GetMapping("/gallery")
	public String getGallery(Model model,HttpSession session) {
		
		if (session.getAttribute("validuser") == null) return "LoginForm";
		
		String[] imageName = new File("src/main/resources/static/images").list();
		model.addAttribute("imglist",imageName);
		
		return "GalleryForm";
	}

}
