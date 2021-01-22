package com.workshop.teste.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.workshop.teste.entity.Usuario;

public class UsuarioResponse {

	@JsonProperty(value = "id_user")
	private Long id;
	
	@JsonProperty(value = "nome")
	private String nome;
	
	@JsonProperty(value = "Username")
	private String username;
	
	@JsonProperty(value = "CPF")
	private String cpf;
	
	@JsonProperty(value = "Id_Carteira")
	private Long carteira;

	public UsuarioResponse() {}
	
	public UsuarioResponse(Long id, String nome, String username, String cpf, Long carteira) {
		super();
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.cpf = cpf;
		this.carteira = carteira;
	}
	
	public UsuarioResponse(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.username = usuario.getUsername();
		this.cpf = usuario.getCpf();
		this.carteira = usuario.getCarteira();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getCarteira() {
		return carteira;
	}

	public void setCarteira(Long carteira) {
		this.carteira = carteira;
	}
}
