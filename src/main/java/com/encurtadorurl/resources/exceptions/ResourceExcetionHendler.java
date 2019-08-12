package com.encurtadorurl.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.encurtadorurl.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExcetionHendler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), "Não encontrado",  e.getMessage(), request.getRequestURI(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<StandardError> objectNotFound(NumberFormatException e, HttpServletRequest request){
		StandardError error = new StandardError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao tentar encurtar URL",  e.getMessage(), request.getRequestURI(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	
}
