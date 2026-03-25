package com.cdsc.spirngmvcdemo.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdsc.spirngmvcdemo.model.Department;
import com.cdsc.spirngmvcdemo.repository.DepartmentRepository;
import com.cdsc.spirngmvcdemo.service.DepartmentService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	public void addDepartment(Department dept) {

		dept.setDeptId(UUID.randomUUID().toString());
		deptRepo.save(dept);
	}

	@Override
	public void deleteDepartment(String deptId) {
		deptRepo.deleteById(deptId);
	}

	@Override
	public void updateDepartment(Department dept) {
		deptRepo.save(dept);
	}

	@Override
	public Department getDepartmentById(String deptId) {

		return deptRepo.findById(deptId).get();
	}

	@Override
	public List<Department> getAllDepartments() {

		return deptRepo.findAll();
	}

	@Override
	public List<Department> searchDepartment(String sdata) {

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("search_dept", Department.class);

		query.registerStoredProcedureParameter("s_data", String.class, ParameterMode.IN);

		query.setParameter("s_data", sdata != null && !sdata.isEmpty() ? sdata : null);

		List<Department> list = query.getResultList();
		System.out.println("----size---= " + list.size());

		return list;// deptRepo.findByDeptNameContaining(deptName);
	}

}
