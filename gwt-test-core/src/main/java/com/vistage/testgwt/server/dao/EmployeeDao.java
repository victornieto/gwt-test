package com.vistage.testgwt.server.dao;

import java.util.List;

import com.vistage.testgwt.server.model.Employee;

public interface EmployeeDao
{

	List<Employee> getList();

	Employee create(Employee employee);

	void update(Employee employee);

	void delete(Integer id);

	Employee getEmployee(Integer id);

}
