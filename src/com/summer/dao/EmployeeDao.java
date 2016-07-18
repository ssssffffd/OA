package com.summer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.summer.model.Employee;

@Repository("employeeDao")
public class EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void add(Employee employee) {
		String sql = "insert into employee ( name, password, dep_id, position, salary, sex, if_manager ) values ( ?, ?, ?, ?, ?, ?, ? )";
		Object[] params = new Object[]{employee.getName(),employee.getPassword(),employee.getDep_id(),employee.getPosition(),employee.getSalary(),employee.getSex(),employee.getIf_manager()};
		jdbcTemplate.update(sql,params);
	}
	
	public void delete(int id) {
		jdbcTemplate.update("delete from employee where id = ?", id );
	}

	public void update(Employee employee) {
		String sql = "update employee set name = ?, password = ?, dep_id = ?, position = ?, salary = ?, sex = ?, if_manager = ? where id = ?";
		Object[] params = new Object[]{employee.getName(),employee.getPassword(),employee.getDep_id(),employee.getPosition(),employee.getSalary(),employee.getSex(),employee.getIf_manager(),employee.getId()};
		System.out.println("update ret:"+jdbcTemplate.update(sql, params));
	}
	
	public List<Employee> getEmployeeByDep_id(int dep_id) {
		String sql = "select * from employee where dep_id = ? ";
		return jdbcTemplate.query(sql, new Object[]{dep_id}, new EmployeeMapper());
	}
	
	public Employee getEmployeeById(int id) {
		String sql="select * from employee where id = ?";
		List<Employee>list = jdbcTemplate.query(sql, new Object[]{id}, new EmployeeMapper());
		if(list.isEmpty()) return null;
		else return list.get(0);
	}
	
	public List<Employee> getAllEmployees(){
		String sql="select * from employee ";
		return jdbcTemplate.query(sql, new EmployeeMapper());
	}
	

	private class EmployeeMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee=new Employee();
			employee.setId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			employee.setPassword(rs.getString("password"));
			employee.setDep_id(rs.getInt("dep_id"));
			employee.setPosition(rs.getString("position"));
			employee.setSalary(rs.getInt("salary"));
			employee.setSex(rs.getBoolean("sex"));
			employee.setIf_manager(rs.getBoolean("if_manager"));
			return employee;
		}
	
	}
}
