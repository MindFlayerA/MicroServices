package com.codeseeker.microUserService.ui.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class UsersServiceExceptionHandler extends ResponseEntityExceptionHandler 
{
	@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<Object> handlePageNotFound(NullPointerException ex, WebRequest wr){
		return new ResponseEntity<Object>(ex, HttpStatus.ALREADY_REPORTED);
	}
}
