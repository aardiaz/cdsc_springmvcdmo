package com.cdsc.spirngmvcdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cdsc.spirngmvcdemo.model.Employee;
import com.cdsc.spirngmvcdemo.service.DepartmentService;
import com.cdsc.spirngmvcdemo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/employee")
	public String getEmployee(Model model) {
		
		model.addAttribute("dList",deptService.getAllDepartments());
		return "EmployeeForm";
	}
	
	
	@PostMapping("/employee")
	public String postEmployee(@ModelAttribute Employee emp,Model model) {
		
		empService.addEmp(emp);
		return "redirect:/employee";
	}
	
}
