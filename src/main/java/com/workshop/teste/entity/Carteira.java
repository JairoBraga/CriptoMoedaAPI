package com.workshop.teste.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARTEIRAS")
public class Carteira implements Serializable{
	
	private static final long serialVersionUID = 8688126572657759739L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARTEIRA_ID")
	private Long id;
	
	@Column(name = "USUARIO_ID")
	private Long id_user;
	
	@Column(name = "MOEDA_ID")
	private Long id_moedas;


	public Carteira() {}

	public Carteira(Long id_user) {
		this.id_user = id_user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Long getId_moedas() {
		return id_moedas;
	}

	public void setId_moedas(Long id_moedas) {
		this.id_moedas = id_moedas;
	}
	
}
