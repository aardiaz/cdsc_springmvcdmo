package com.cdsc.spirngmvcdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cdsc.spirngmvcdemo.model.Department;
import com.cdsc.spirngmvcdemo.service.DepartmentService;

@SpringBootApplication
public class SpringmvcdemoApplication implements CommandLineRunner {
	
	@Autowired
	private DepartmentService deptService;

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 
		List<Department>  dlist = deptService.searchDepartment("5");
		System.out.println("---size===="+dlist.size());
		System.out.println(dlist);
	}

}
