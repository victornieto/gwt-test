package com.vistage.testgwt.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vistage.testgwt.server.dao.EmployeeDao;
import com.vistage.testgwt.server.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Transactional(readOnly = true)
	@Override
	public List<Employee> getList() {
		return employeeDao.getList();
	}

	@Transactional(readOnly = true)
	@Override
	public Employee create(Employee employee)
	{
		return employeeDao.create(employee);
	}
}
