package com.workshop.teste.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CARTEIRAS")
public class Carteira implements Serializable{
	
	private static final long serialVersionUID = 8688126572657759739L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARTEIRA_ID")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "USUARIO_ID")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "id.carteira")
	private Set<CarteiraMoedas> moedas = new HashSet<>();
	
	public Carteira(){	
	}

	public Carteira(Long id, Set<CarteiraMoedas> moedas) {
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

	public Set<CarteiraMoedas> getMoedas() {
		return moedas;
	}

	public void setMoedas(Set<CarteiraMoedas> moedas) {
		this.moedas = moedas;
	}
}