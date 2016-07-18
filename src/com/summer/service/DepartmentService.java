package com.summer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summer.dao.DepartmentDao;
import com.summer.dao.EmployeeDao;
import com.summer.model.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private EmployeeDao employeeDao;
	
	public boolean add(Department department) {
		if(employeeDao.getEmployeeById(department.getLeader_id())==null)
			return false;
		departmentDao.add(department);
		return true;
	}

	public void delete(int id) {
		departmentDao.delete(id);
	}

	public boolean update(Department department) {
		if(employeeDao.getEmployeeById(department.getLeader_id())==null)
			return false;
		departmentDao.update(department);
		return true;
	}

	public List<Department> getAllDepartments() {
		return departmentDao.getAllDepartments();
	}

	public Department getDepartmentById(int id) {
		return departmentDao.getDepartementById(id);
	}

	public List<Department> getDepartmentByLeader_id(int leader_id) {
		return departmentDao.getDepartmentByLeader_id(leader_id);
	}
}
