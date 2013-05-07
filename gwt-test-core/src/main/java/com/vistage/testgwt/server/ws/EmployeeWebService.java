package com.vistage.testgwt.server.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vistage.testgwt.server.model.Employee;
import com.vistage.testgwt.server.service.EmployeeService;
import com.vistage.testgwt.server.ws.model.EmployeeListResponse;
import com.vistage.testgwt.server.ws.model.NewEmployeeRequest;
import com.vistage.testgwt.server.ws.model.NewEmployeeResponse;

@Service
@Path("/employees")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class EmployeeWebService
{

	@Autowired
	private EmployeeService employeeService;

	@GET
	@Path("/")
	public EmployeeListResponse getEmployeeList()
	{

		final List<Employee> employees = employeeService.getList();
		EmployeeListResponse employeeListResponse = new EmployeeListResponse();
		employeeListResponse.setStatus(1);
		employeeListResponse.setEmployees(employees);

		return employeeListResponse;
	}

	@POST
	@Path("/new")
	public NewEmployeeResponse newEmployee(NewEmployeeRequest request)
	{

		Employee employee = new Employee();
		employee.setName(request.getName());
		employee.setSalary(request.getSalary());
		employee.setHireDate(request.getHireDate());

		Employee employeResponse = employeeService.create(employee);

		NewEmployeeResponse newEmployeeResponse = new NewEmployeeResponse();
		newEmployeeResponse.setStatus(1);
		newEmployeeResponse.setEmployee(employeResponse);

		return newEmployeeResponse;
	}
}
