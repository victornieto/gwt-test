package com.vistage.testgwt.server.ws.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "newEmployeeRequest")
public class NewEmployeeRequest
{
	private String name;
	private Double salary;
	private Date hireDate;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Double getSalary()
	{
		return salary;
	}

	public void setSalary(Double salary)
	{
		this.salary = salary;
	}

	public Date getHireDate()
	{
		return hireDate;
	}

	public void setHireDate(Date hireDate)
	{
		this.hireDate = hireDate;
	}

}
