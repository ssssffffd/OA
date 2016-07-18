package com.summer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.summer.model.Department;

@Repository("departmentDao")
public class DepartmentDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public void add(Department department) {
		String sql = "insert into department ( name, leader_id ) values(?, ?)";
		Object[] params = new Object[]{department.getName(),department.getLeader_id()};
		jdbcTemplate.update(sql,params);
	}

	public void delete(int id) {
		jdbcTemplate.update("delete from department where id = ?", id );
	}

	public void update(Department department) {
		String sql = "update department set name = ?, leader_id = ? where id = ?";
		Object[] params = new Object[]{department.getName(),department.getLeader_id(),department.getId()};
		jdbcTemplate.update(sql, params);
	}

	public List<Department> getAllDepartments() {
		String sql = "select * from department ";
		return jdbcTemplate.query(sql, new DepartmentMapper());
	}

	public Department getDepartementById(int id) {
		String sql="select * from department where id = ?";
		List<Department>list = jdbcTemplate.query(sql, new Object[]{id}, new DepartmentMapper());
		if(list.isEmpty()) return null;
		else return list.get(0);
	}
	
	public List<Department> getDepartmentByLeader_id(int leader_id){
		String sql="select * from department where leader_id= ? ";
		return jdbcTemplate.query(sql, new Object[]{leader_id}, new DepartmentMapper());
	}
	
	private class DepartmentMapper implements RowMapper<Department> {

		@Override
		public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
			Department department=new Department();
			department.setId(rs.getInt("id"));
			department.setName(rs.getString("name"));
			department.setLeader_id(rs.getInt("leader_id"));
			return department;
		}
	
	}

}
