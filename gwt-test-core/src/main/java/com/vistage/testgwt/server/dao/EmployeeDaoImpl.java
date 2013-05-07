package com.vistage.testgwt.server.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vistage.testgwt.server.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao
{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getList()
	{
		return jdbcTemplate.query("select id, name, hire_date, salary from employee", new EmployeeMapper());
	}

	@Override
	public Employee create(Employee employee)
	{
		final String SQL = "insert into employee (name, hire_date, salary) values (?, ?, ?) ";
		
		jdbcTemplate.update(SQL, employee.getName(), employee.getHireDate(), employee.getSalary());
		
		return employee;
	}

	@Override
	public Employee getEmployee(Integer id)
	{
		final String SQL = "select id, name, hire_date, salary from employee where id = ?";
		Employee student = jdbcTemplate.queryForObject(SQL, new Object[] {id}, new EmployeeMapper());
		return student;
	}

	@Override
	public void delete(Integer id)
	{
		final String SQL = "delete from Student where id = ?";
		jdbcTemplate.update(SQL, id);
	}

	@Override
	public void update(Employee employee)
	{
		final String SQL = "update Student set name = ?, hire_date = ?, salary = ? where id = ?";
		jdbcTemplate.update(SQL, employee.getName(), employee.getHireDate(), employee.getSalary());
	}
}
