package com.hexaware.fastx.customexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BadRequestException extends RuntimeException{
	
	private HttpStatus status;
	private String message;
	public BadRequestException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public BadRequestException(HttpStatus status, String message, String message2) {
		super(message);
		this.status = status;
		this.message = message2;
	}
	public BadRequestException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "BadRequestException [status=" + status + ", message=" + message + "]";
	}

}
