package com.workshop.teste.exceptions;

import java.time.Instant;

public class StandardError {
	
	private Instant timeStamp;
	private String error;
	private Integer status;
	private String message;
	private String path;
	
	public StandardError() {
	}

	public StandardError(Instant timeStamp,String error, Integer status, String message, String path) {
		this.timeStamp = timeStamp;
		this.error = error;
		this.status = status;
		this.message = message;
		this.path = path;
	}
	

	public Instant getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}