package com.pramod.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.apache.commons.httpclient.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class UserNotFoundException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest wr){
		
		ExceptionCustom e = new ExceptionCustom(new Date(),ex.getMessage(),wr.getDescription(false));
		return new ResponseEntity<Object>(e,HttpStatus.NOT_FOUND);
		}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionCustom e = new ExceptionCustom(new Date(),"validation failed",ex.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<Object>(e,HttpStatus.BAD_REQUEST);
	}
}
