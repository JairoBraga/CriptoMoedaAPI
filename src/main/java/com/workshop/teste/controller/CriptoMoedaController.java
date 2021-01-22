package com.workshop.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.teste.exceptions.CoinNotFoundException;
import com.workshop.teste.request.CriptoMoedaRequest;
import com.workshop.teste.response.CriptoMoedaResponse;
import com.workshop.teste.service.CriptoMoedaService;

@RestController
@RequestMapping(value = "/cripto_moedas")
public class CriptoMoedaController {
	
	@Autowired
	private CriptoMoedaService service;
	
	@GetMapping
	public ResponseEntity<List<CriptoMoedaResponse>> buscarTodasAsMoedas() {
		return new ResponseEntity<>(service.buscarTodasAsMoedas(), HttpStatus.OK);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarMoedas(@RequestBody CriptoMoedaRequest request) {
		service.salvarMoeda(request);
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CriptoMoedaResponse> buscarMoedaPorId(@PathVariable Long id) throws Exception {
		CriptoMoedaResponse response = service.buscarMoedaPorId(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarMoeda(@RequestBody CriptoMoedaRequest request) throws CoinNotFoundException {
		service.updateMoeda(request);
	}

}
