package com.cdsc.spirngmvcdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cdsc.spirngmvcdemo.model.Department;
import com.cdsc.spirngmvcdemo.service.DepartmentService;
import com.cdsc.spirngmvcdemo.utils.DepartmentExcelView;
import com.cdsc.spirngmvcdemo.utils.DepartmentPdfView;

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

	@GetMapping("/list")
	public String getAllDepts(Model model) {

		model.addAttribute("deptList", deptService.getAllDepartments());
		return "DepartmentListForm";
	}

	@GetMapping("/delete")
	public String deleteDept(@RequestParam("id") String dId) {

		deptService.deleteDepartment(dId);
		return "redirect:list";
	}

	@GetMapping("/edit")
	public String editDept(@RequestParam("id") String dId, Model model) {

		model.addAttribute("dModel", deptService.getDepartmentById(dId));
		return "DepartmentEditForm";
	}

	@PostMapping("/update")
	public String updateDept(@ModelAttribute Department dept) {

		deptService.updateDepartment(dept);

		return "redirect:list";
	}

	@GetMapping("/search")
	public List<Department> search(@RequestParam(required = false) String name) {
		return deptService.searchDepartment(name);
	}
	
	
	
	
	@GetMapping("/excel")
	public ModelAndView getExcel() {
		
		ModelAndView mv  = new ModelAndView();
		mv.addObject("dList", deptService.getAllDepartments());
		mv.setView(new DepartmentExcelView());
		
		return mv;
	}
	
	@GetMapping("/pdf")
	public ModelAndView getPdf() {
		
		ModelAndView mv  = new ModelAndView();
		mv.addObject("dList", deptService.getAllDepartments());
		mv.setView(new DepartmentPdfView());
		
		return mv;
	}

}
