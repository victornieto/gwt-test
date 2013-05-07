package com.vistage.testgwt.server.ws.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.vistage.testgwt.server.model.Employee;

@XmlRootElement(name = "employeeListResponse")
public class EmployeeListResponse
{

	private Integer status;
	private List<Employee> employees;

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public List<Employee> getEmployees()
	{
		return employees;
	}

	public void setEmployees(List<Employee> employees)
	{
		this.employees = employees;
	}

}
