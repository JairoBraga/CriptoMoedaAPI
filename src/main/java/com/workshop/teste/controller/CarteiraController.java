package com.workshop.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.teste.response.CarteiraResponse;
import com.workshop.teste.service.CarteiraService;

@RestController
@RequestMapping(value = "/carteira")
public class CarteiraController {
	
	@Autowired
	private CarteiraService service;
		
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CarteiraResponse buscarCarteiraPorId(@PathVariable(value = "id") Long id) {
		return service.buscarCarteiraPorId(id);
	}
}
