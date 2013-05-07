package com.vistage.testgwt.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vistage.testgwt.server.model.Employee;

public class EmployeeMapper implements RowMapper<Employee>
{
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Employee student = new Employee();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setHireDate(rs.getDate("hire_date"));
		student.setSalary(rs.getDouble("salary"));
		return student;
	}
}
