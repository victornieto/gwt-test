package com.vistage.testgwt.server.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

	private static final long serialVersionUID = -7980180422918968136L;

	private Integer id;

	private String name;

	private Double salary;

	private Date hireDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

}
