package com.excelr.ExcelrSeptSpringboot.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PlayerNotFoundException.class)
	public ResponseEntity<String> handlePlayerNotFoundExceptionExceptions(PlayerNotFoundException ex) 
	{
		return new ResponseEntity<String>(ex.getMessage()+" From Global EH", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<APIError>>  handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) 
	{
		List<APIError> errors = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) 
		{
		APIError apiError = new APIError(error.getDefaultMessage()+"GEH", error.getField(), error.getRejectedValue()+"GEH");
		errors.add(apiError);
		}
		return new ResponseEntity<List<APIError>>(errors, HttpStatus.BAD_REQUEST);
	}
}
