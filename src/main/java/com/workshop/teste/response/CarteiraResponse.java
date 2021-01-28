package com.workshop.teste.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.workshop.teste.entity.CriptoMoeda;

public class CarteiraResponse {

	@JsonProperty(value = "id_carteira")
	private Long id;
		
	private List<CriptoMoeda> moedas;

	public CarteiraResponse() {
	}

	public CarteiraResponse(Long id, List<CriptoMoeda> moedas) {
		super();
		this.id = id;
		this.moedas = moedas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CriptoMoeda> getMoedas() {
		return moedas;
	}

	public void setMoedas(List<CriptoMoeda> moedas) {
		this.moedas = moedas;
	}
	
}
