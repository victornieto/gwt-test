package com.vistage.testgwt.server.service;

import java.util.List;

import com.vistage.testgwt.server.model.Employee;

public interface EmployeeService {

	List<Employee> getList();

	Employee create(Employee employee);

}
