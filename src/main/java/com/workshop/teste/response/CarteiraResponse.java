package com.workshop.teste.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.workshop.teste.entity.Carteira;

public class CarteiraResponse {

	@JsonProperty(value = "id_carteira")
	private Long id;
	
	@JsonProperty(value = "id_user")
	private Long id_user;
	
	@JsonProperty(value = "moeda_id")
	private Long id_moedas;

	public CarteiraResponse() {
	}
	
	public CarteiraResponse(Carteira carteira) {
		this.id = carteira.getId();
		this.id_user = carteira.getId_user();
		this.id_moedas = carteira.getId_moedas();
	}

	public CarteiraResponse(Long id, Long id_user, Long id_moedas) {
		this.id = id;
		this.id_user = id_user;
		this.id_moedas = id_moedas;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_moedas == null) ? 0 : id_moedas.hashCode());
		result = prime * result + ((id_user == null) ? 0 : id_user.hashCode());
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
		CarteiraResponse other = (CarteiraResponse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_moedas == null) {
			if (other.id_moedas != null)
				return false;
		} else if (!id_moedas.equals(other.id_moedas))
			return false;
		if (id_user == null) {
			if (other.id_user != null)
				return false;
		} else if (!id_user.equals(other.id_user))
			return false;
		return true;
	}
}
