package com.pramod.exceptions;

import java.util.Date;

//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExceptionCustom{
	
	private Date timestamp;
	private String message,details;
	public ExceptionCustom() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public ExceptionCustom(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}




	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	public Date getTimestamp() {
		return timestamp;
	}




	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}
