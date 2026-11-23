package com.excelr.ExcelrSeptSpringboot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class APIError {
	private String field;
	private Object rejectedValue;
	private String defaultMessage;
}
