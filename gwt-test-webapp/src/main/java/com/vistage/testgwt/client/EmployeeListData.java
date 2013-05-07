package com.vistage.testgwt.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public final class EmployeeListData extends JavaScriptObject{
	
	protected EmployeeListData(){}
	
	public final native int getStatus() /*-{ return this.status; }-*/; // (3)
	public final native JsArray<EmployeeData> getEmployees() /*-{ return this.employees; }-*/; // (3)

}
