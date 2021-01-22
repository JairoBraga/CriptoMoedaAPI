package com.workshop.teste.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Moedas_carteira")
public class MoedaUser implements Serializable{

	private static final long serialVersionUID = -54914737418287307L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOEDA_ID")
	private Long id_moedas;
	
	@Column(name = "CARTEIRA_ID")
	private Long id_carteira;
	
	@Column(name = "ID_COIN")
	private Long id_cr;
	
	@Column(name = "QUANTIDADE")
	private Double quantidade;

	public MoedaUser() {

	}

	public MoedaUser(Long id_moedas, Long id_carteira, Long id_cr, Double quantidade) {
		this.id_moedas = id_moedas;
		this.id_carteira = id_carteira;
		this.id_cr = id_cr;
		this.quantidade = quantidade;
	}
	
	public Long getId_moedas() {
		return id_moedas;
	}

	public void setId_moedas(Long id_moedas) {
		this.id_moedas = id_moedas;
	}

	public Long getId_carteira() {
		return id_carteira;
	}

	public void setId_carteira(Long id_carteira) {
		this.id_carteira = id_carteira;
	}

	public Long getId_cr() {
		return id_cr;
	}

	public void setId_cr(Long id_cr) {
		this.id_cr = id_cr;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
}
