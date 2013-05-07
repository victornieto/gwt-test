package com.vistage.testgwt.client;

import com.google.gwt.core.client.JavaScriptObject;

public final class EmployeeData extends JavaScriptObject{
	
	protected EmployeeData(){}
	
	public final native String getName() /*-{ return this.name; }-*/; // (3)
	public final native String getHireDate() /*-{ return this.hireDate; }-*/;
	public final native double getSalary() /*-{ return this.salary; }-*/;
}
