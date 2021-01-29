package com.workshop.teste.entity.embedded;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.workshop.teste.entity.Carteira;
import com.workshop.teste.entity.CriptoMoeda;

@Embeddable
public class CarteiraMoedaEmbedded implements Serializable{
	
	private static final long serialVersionUID = -2897371180110439682L;

	@ManyToOne
	@JoinColumn(name = "CARTEIRA_ID")
	private Carteira carteira;
	
	@ManyToOne
	@JoinColumn(name = "CR_ID")
	private CriptoMoeda criptoMoeda;

	public Carteira getCarteira() {
		return carteira;
	}

	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}

	public CriptoMoeda getCriptoMoeda() {
		return criptoMoeda;
	}

	public void setCriptoMoeda(CriptoMoeda criptoMoeda) {
		this.criptoMoeda = criptoMoeda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carteira == null) ? 0 : carteira.hashCode());
		result = prime * result + ((criptoMoeda == null) ? 0 : criptoMoeda.hashCode());
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
		CarteiraMoedaEmbedded other = (CarteiraMoedaEmbedded) obj;
		if (carteira == null) {
			if (other.carteira != null)
				return false;
		} else if (!carteira.equals(other.carteira))
			return false;
		if (criptoMoeda == null) {
			if (other.criptoMoeda != null)
				return false;
		} else if (!criptoMoeda.equals(other.criptoMoeda))
			return false;
		return true;
	}

	
}
