package com.commerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ProductExceptionHandler {
	
	@ExceptionHandler(value = ProductNotfoundException.class)
	public ResponseEntity<Object> exception(ProductNotfoundException exception) {
	      return new ResponseEntity<>("Products not found: Possible reason- Name doesn not exist", HttpStatus.NOT_FOUND);
	   }

	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
	  ErrorMessage ErrorMessage = new ErrorMessage( ex.getMessage(), request.getDescription(false));
	  return new ResponseEntity<>(ErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	
}
