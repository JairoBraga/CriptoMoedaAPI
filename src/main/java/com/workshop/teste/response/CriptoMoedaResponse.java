package com.workshop.teste.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.workshop.teste.entity.CriptoMoeda;

public class CriptoMoedaResponse implements Serializable {

	private static final long serialVersionUID = -4443292745315240380L;

	@JsonProperty(value = "ID_MOEDA")
	private Long id;
	
	@JsonProperty(value = "NOME_DA_MOEDA")
	private String nomeDaMoeda;
	
	@JsonProperty(value = "SIMBOLO_DA_MOEDA")
	private String simbolo;
	
	@JsonProperty(value = "PRECO_DA_MOEDA")
	private Double preco;

	public CriptoMoedaResponse() {
	}

	public CriptoMoedaResponse(Long id,String nomeDaMoeda, String simbolo, Double preco) {
		this.id = id;
		this.nomeDaMoeda = nomeDaMoeda;
		this.simbolo = simbolo;
		this.preco = preco;
	}
	
	public CriptoMoedaResponse(CriptoMoeda entity) {
		this.id=entity.getId();
		this.nomeDaMoeda = entity.getNomeDaMoeda();
		this.simbolo = entity.getSimbolo();
		this.preco = entity.getPreco();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeDaMoeda == null) ? 0 : nomeDaMoeda.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((simbolo == null) ? 0 : simbolo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CriptoMoedaResponse other = (CriptoMoedaResponse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeDaMoeda == null) {
			if (other.nomeDaMoeda != null)
				return false;
		} else if (!nomeDaMoeda.equals(other.nomeDaMoeda))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (simbolo == null) {
			if (other.simbolo != null)
				return false;
		} else if (!simbolo.equals(other.simbolo))
			return false;
		return true;
	}
	
}
