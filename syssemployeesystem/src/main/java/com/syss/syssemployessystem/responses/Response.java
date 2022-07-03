package com.syss.syssemployessystem.responses;

import java.util.List;

public class Response<T> {

	private T data;
	private List<String> error;
	
	public Response (T data) {
		this.data = data;
	}
	
	public Response(List<String> error) {
		this.error = error;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getError() {
		return error;
	}

	public void setError(List<String> error) {
		this.error = error;
	}
	
	
	
	
}
