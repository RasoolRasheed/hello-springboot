package com.rasool.test.dto;

import java.util.List;

public class AccessibleFunction {

	private long functionId;
	private String name;
	private String icon;
	private String url;
	private List<AccessibleFunction> childFunctions;
	
	public long getFunctionId() {
		return functionId;
	}
	public void setFunctionId(long functionId) {
		this.functionId = functionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<AccessibleFunction> getChildFunctions() {
		return childFunctions;
	}
	public void setChildFunctions(List<AccessibleFunction> childFunctions) {
		this.childFunctions = childFunctions;
	}
}
