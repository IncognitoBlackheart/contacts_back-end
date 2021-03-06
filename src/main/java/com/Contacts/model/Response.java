package com.Contacts.model;

import java.util.HashMap;
import java.util.Map;

public class Response<T> {
	private T data;
	private int status;
	private Map<String, String> errors;

	public Response() {
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public Map<String, String> getErrors() {
		if (this.errors == null) {
			this.errors = new HashMap<String, String>();
		}
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
}