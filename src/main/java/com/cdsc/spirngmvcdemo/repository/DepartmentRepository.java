package com.cdsc.spirngmvcdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdsc.spirngmvcdemo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, String>{

	List<Department> findByDeptNameContaining(String deptName);
	
}
