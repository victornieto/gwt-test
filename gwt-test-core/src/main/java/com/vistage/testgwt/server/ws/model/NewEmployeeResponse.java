package com.vistage.testgwt.server.ws.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.vistage.testgwt.server.model.Employee;

@XmlRootElement(name = "newEmployeeResponse")
public class NewEmployeeResponse
{

	private Integer status;
	private Employee employee;

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

}
