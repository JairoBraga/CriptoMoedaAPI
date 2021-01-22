package com.workshop.teste.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOEDAS")
public class CriptoMoeda implements Serializable{

	private static final long serialVersionUID = -2656750008483749601L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CR_ID")
	private Long id;
	
	@Column(name = "CR_NOME")
	private String nomeDaMoeda;
	
	@Column(name = "CR_SIMBOLO")
	private String simbolo;
	
	@Column(name = "CR_PRECO")
	private Double preco;
	
	
	public CriptoMoeda() {
	}
	
	public CriptoMoeda(Long id,String nomeDaMoeda, String simbolo, Double preco) {
		this.id = id;
		this.nomeDaMoeda = nomeDaMoeda;
		this.simbolo = simbolo;
		this.preco = preco;
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
		CriptoMoeda other = (CriptoMoeda) obj;
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
