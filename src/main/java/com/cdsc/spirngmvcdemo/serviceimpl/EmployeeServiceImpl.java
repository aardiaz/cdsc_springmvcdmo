package com.cdsc.spirngmvcdemo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdsc.spirngmvcdemo.model.Employee;
import com.cdsc.spirngmvcdemo.repository.EmployeeRepository;
import com.cdsc.spirngmvcdemo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository  empRepo;

	@Override
	public void addEmp(Employee emp) {
		empRepo.save(emp);
	}

	@Override
	public void deleteEmp(long id) {
		empRepo.deleteById(id);
	}

	@Override
	public void updateEmp(Employee emp) {
		empRepo.save(emp);
	}

	@Override
	public Employee getEmpById(long id) {
		  
		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmps() {
		return empRepo.findAll();
	}

}
