package com.workshop.teste.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CARTEIRAS")
public class Carteira implements Serializable{
	
	private static final long serialVersionUID = 8688126572657759739L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARTEIRA_ID")
	private Long id;
	
	@OneToMany(mappedBy = "carteira")
	private List<CriptoMoeda> moedas;
	
	public Carteira(){	
	}

	public Carteira(Long id, List<CriptoMoeda> moedas) {
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