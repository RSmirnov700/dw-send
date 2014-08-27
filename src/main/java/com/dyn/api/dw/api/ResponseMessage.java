package com.dyn.api.dw.api;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName ("response")
public class ResponseMessage {
	
	public ResponseMessage() {
	}

	public ResponseMessage(int status, String message, String data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	private int status;
	
	private String message;
	
	private String data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	

}
