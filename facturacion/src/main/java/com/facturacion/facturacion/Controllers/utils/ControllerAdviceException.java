package com.facturacion.facturacion.Controllers.utils;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.facturacion.facturacion.Controllers.Ëxceptions.ExceptionController;

@RestControllerAdvice
public class ControllerAdviceException {

    @ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ExceptionController> _409ExceptionHandler(final RuntimeException exception){

		ExceptionController err = new ExceptionController("REQ-409", exception.getMessage());
		
		return new ResponseEntity<>(err, HttpStatus.CONFLICT);
	}
   
}
