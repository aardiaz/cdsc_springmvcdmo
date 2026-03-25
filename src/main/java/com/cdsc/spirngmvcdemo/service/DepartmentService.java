package com.cdsc.spirngmvcdemo.service;

import java.util.List;

import com.cdsc.spirngmvcdemo.model.Department;

public interface DepartmentService {

	void addDepartment(Department dept);

	void deleteDepartment(String deptId);

	void updateDepartment(Department dept);

	Department getDepartmentById(String deptId);

	List<Department> getAllDepartments();

	List<Department> searchDepartment(String sdata);

}
