package com.workshop.teste.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = -6562920016313306095L;
	
	public UserNotFoundException() {
		super("usuario não encontrado");
	}
}
