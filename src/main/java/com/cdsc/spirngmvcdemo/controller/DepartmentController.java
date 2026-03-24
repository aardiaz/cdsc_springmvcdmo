package com.cdsc.spirngmvcdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdsc.spirngmvcdemo.model.Department;
import com.cdsc.spirngmvcdemo.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/create")
	public String getDeptForm() {
		
		return "DepartmentAddForm";
	}
	
	@PostMapping("/create")
	public String postDept(@ModelAttribute Department dept) {
		
		deptService.addDepartment(dept);
		return "DepartmentAddForm";
	}
	
}
