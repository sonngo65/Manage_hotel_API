package com.example.ShopWebAPI.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(IllegalAccessException.class)
	public ResponseEntity<ErrorResponse> illegalAccessExceptionHandler(IllegalAccessException e,WebRequest webRequest){
		ErrorResponse errorResponse = new ErrorResponse(new Date(),e.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler()
	public ResponseEntity<ErrorResponse> globalExceptionHandler(Exception e,WebRequest webRequest){
		ErrorResponse errorResponse = new ErrorResponse(new Date(),e.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
