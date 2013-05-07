package com.vistage.testgwt.client;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtClient implements EntryPoint
{

	private static final String EMPLOYEES_URL = GWT.getHostPageBaseURL() + "services/employees/";
	private static final String JSON_CONTENT_TYPE = "application/json";
	private static final DateTimeFormat DATE_FORMAT_INPUT = DateTimeFormat.getFormat("yyyy-MM-ddThh:mm:ssZ");
	private static final DateTimeFormat DATE_FORMAT_OUTPUT = DateTimeFormat.getFormat("yyyy-dd-MM");
	private static final NumberFormat NUMBER_FORMAT_OUTPUT = NumberFormat.getCurrencyFormat();

	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable employeesTable = new FlexTable();
	private Label errorMsgLabel = new Label();

	public void onModuleLoad()
	{
		errorMsgLabel.setVisible(false);
		mainPanel.add(errorMsgLabel);

		// initialize table
		employeesTable.getRowFormatter().addStyleName(0, "listHeader");	
		employeesTable.setCellPadding(6);
		
		employeesTable.setText(0, 0, "Name");
		employeesTable.setText(0, 1, "Hire Date");
		employeesTable.setText(0, 2, "Salary");


		mainPanel.add(employeesTable);

		RootPanel.get("employeesPanel").add(mainPanel);

		updateEmployees();
	}

	private void updateEmployees()
	{

		// Send request to server and catch any errors.
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, EMPLOYEES_URL);
		builder.setHeader("Accept", JSON_CONTENT_TYPE);

		try
		{
			builder.sendRequest(null, new RequestCallback()
			{
				public void onError(Request request, Throwable exception)
				{
					displayError("Couldn't retrieve JSON");
				}

				public void onResponseReceived(Request request, Response response)
				{
					if (200 == response.getStatusCode())
					{
						updateEmployeesTable(response.getText());
						errorMsgLabel.setVisible(false);
					}
					else
					{
						displayError("Couldn't retrieve JSON (" + response.getStatusText() + ")");
					}
				}
			});
		}
		catch (RequestException e)
		{
			displayError("Couldn't retrieve JSON");
		}

	}

	private void updateEmployeesTable(String json)
	{

		EmployeeListData employeeListData = asEmployeeListData(json);

		JsArray<EmployeeData> employees = employeeListData.getEmployees();

		for (int i = 0; i < employees.length(); i++)
		{
			EmployeeData employeeData = employees.get(i);
			employeesTable.setText(i + 1, 0, employeeData.getName());
			Date hireDate = DATE_FORMAT_INPUT.parse(employeeData.getHireDate());
			employeesTable.setText(i + 1, 1, DATE_FORMAT_OUTPUT.format(hireDate));
			employeesTable.setText(i + 1, 2, NUMBER_FORMAT_OUTPUT.format(employeeData.getSalary()));
		}
	}

	/**
	 * Convert the string of JSON into JavaScript object.
	 */
	protected final native EmployeeListData asEmployeeListData(String json) /*-{
		eval('var resp = ' + json);
		return resp.employeeListResponse;
	}-*/;

	private void displayError(String error)
	{
		errorMsgLabel.setText("Error: " + error);
		errorMsgLabel.setVisible(true);
	}
}
