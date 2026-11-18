package com.excelr.ExcelrSeptSpringboot.exception;

public class PlayerNotFoundException extends RuntimeException {

	public PlayerNotFoundException(String errorMessage)
	{
		super(errorMessage);
	}
}
