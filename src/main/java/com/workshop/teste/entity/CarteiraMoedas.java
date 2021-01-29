package com.workshop.teste.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.workshop.teste.entity.embedded.CarteiraMoedaEmbedded;

@Entity
@Table(name = "Carteira_Moedas")
public class CarteiraMoedas {
	
	@EmbeddedId
	private CarteiraMoedaEmbedded id;
	
	private Integer quantidade;
	private Double price;

	public CarteiraMoedas() {
	}

	public CarteiraMoedas(Carteira carteira, CriptoMoeda criptoMoeda, Integer quantidade, Double price) {
		id.setCarteira(carteira);
		id.setCriptoMoeda(criptoMoeda);
		this.quantidade = quantidade;
		this.price = price;
	}

	public CarteiraMoedaEmbedded getId() {
		return id;
	}

	public void setId(CarteiraMoedaEmbedded id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}	
}
