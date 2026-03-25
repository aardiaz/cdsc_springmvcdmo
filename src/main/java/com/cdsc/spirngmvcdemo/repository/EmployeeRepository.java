package com.cdsc.spirngmvcdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdsc.spirngmvcdemo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
}
