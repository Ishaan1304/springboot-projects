package com.ishaan.UserManagementProject.globalException;

import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException {

	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=NullPointerException.class)
	public ResponseEntity<String> handleNullPointerException(NullPointerException ex)
	{
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Null pointer exception has occurred");
    }
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=NumberFormatException.class)
	public ResponseEntity<String> handleNumberFormatException(NumberFormatException ex)
	{
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("NumberFormat exception has occurred");
    }
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=ParseException.class)
	public ResponseEntity<String> handleNumberFormatException(ParseException ex)
	{
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Parse exception has occurred");
    }
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<String> handleException(Exception ex)
	{
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception has occurred");
    }
	
	
}
