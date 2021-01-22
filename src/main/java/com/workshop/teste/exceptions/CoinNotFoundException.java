package com.workshop.teste.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CoinNotFoundException  extends Exception{
	
	private static final long serialVersionUID = 2606699721230152215L;
	
	public CoinNotFoundException() {
		super("Coin not Found");
	}
}
