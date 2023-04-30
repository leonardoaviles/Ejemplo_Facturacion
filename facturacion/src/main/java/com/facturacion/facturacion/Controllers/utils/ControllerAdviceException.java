package com.facturacion.facturacion.Controllers.utils;


import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.facturacion.facturacion.Controllers.Ëxceptions.ExceptionController;

@RestControllerAdvice
public class ControllerAdviceException extends ResponseEntityExceptionHandler{

    @ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<ExceptionController> productNotFound(NoSuchElementException exception){

		ExceptionController err = new ExceptionController(HttpStatus.NOT_FOUND.toString(), exception.getMessage());
		
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<ExceptionController> duplicateElement(DataIntegrityViolationException exception){

		ExceptionController err = new ExceptionController(HttpStatus.CONFLICT.toString(), exception.getMessage());
		
		return new ResponseEntity<>(err, HttpStatus.CONFLICT);
	}
   

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ExceptionController> finalError(final RuntimeException exception){

		ExceptionController err = new ExceptionController(HttpStatus.BAD_REQUEST.toString(), exception.getMessage());
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
}
