package com.workshop.teste.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriptoMoedaRequest {
	
	@JsonProperty(value = "ID_MOEDA")
	private Long id;
	
	@JsonProperty(value = "NOME_DA_MOEDA")
	private String nomeDaMoeda;
	
	@JsonProperty(value = "SIMBOLO_DA_MOEDA")
	private String simbolo;
	
	@JsonProperty(value = "PRECO_DA_MOEDA")
	private Double preco;

	public CriptoMoedaRequest(Long id, String nomeDaMoeda, String simbolo, Double preco) {
		this.id = id;
		this.nomeDaMoeda = nomeDaMoeda;
		this.simbolo = simbolo;
		this.preco = preco;
	}

	public CriptoMoedaRequest() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDaMoeda() {
		return nomeDaMoeda;
	}

	public void setNomeDaMoeda(String nomeDaMoeda) {
		this.nomeDaMoeda = nomeDaMoeda;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
