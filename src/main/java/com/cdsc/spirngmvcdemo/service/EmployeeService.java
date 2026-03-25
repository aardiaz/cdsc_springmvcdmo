package com.cdsc.spirngmvcdemo.service;

import java.util.List;

import com.cdsc.spirngmvcdemo.model.Employee;

public interface EmployeeService {

	void addEmp(Employee emp);

	void deleteEmp(long id);

	void updateEmp(Employee emp);

	Employee getEmpById(long id);

	List<Employee> getAllEmps();

}
