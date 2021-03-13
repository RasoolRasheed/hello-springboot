package com.rasool.test.dto;

import java.util.List;

public class LoginResponse {

	private int code;
	private String message;
	private String token;
	private String name;
	private List<AccessibleFunction> responseData;
	private List<ValidationError> validationErrors;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<AccessibleFunction> getResponseData() {
		return responseData;
	}
	public void setResponseData(List<AccessibleFunction> responseData) {
		this.responseData = responseData;
	}
	public List<ValidationError> getValidationErrors() {
		return validationErrors;
	}
	public void setValidationErrors(List<ValidationError> validationErrors) {
		this.validationErrors = validationErrors;
	}
}