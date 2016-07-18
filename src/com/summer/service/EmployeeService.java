package com.summer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summer.dao.DepartmentDao;
import com.summer.dao.EmployeeDao;
import com.summer.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	DepartmentDao departmentDao;
	
	@Autowired
	DepartmentService departmentService;
	
	public Employee login(Employee employee) {
		Employee e=employeeDao.getEmployeeById(employee.getId());
		if(e.getId()==0 || !e.getPassword().equals(employee.getPassword())){
			return null;
		}
		return e;
	}

	public boolean add(Employee employee) {
		if(departmentDao.getDepartementById(employee.getDep_id())==null)
			return false;
		employeeDao.add(employee);
		return true;
	}

	public boolean delete(int id) {
		if(departmentService.getDepartmentByLeader_id(id).isEmpty()==false) return false;
		employeeDao.delete(id);
		return true;
	}

	public boolean update(Employee employee) {
		if(departmentDao.getDepartementById(employee.getDep_id())==null)
			return false;
		employeeDao.update(employee);
		return true;
	}
	
	public Employee getEmployeeById(int id){
		Employee employee=employeeDao.getEmployeeById(id);
		return employee;
	}
	
	public List<Employee> getAllEmployees(){
		return employeeDao.getAllEmployees();
	}
	
	public List<Employee> getAllEmployeesByDep_id(int dep_id){
		return employeeDao.getEmployeeByDep_id(dep_id);
	}
}
