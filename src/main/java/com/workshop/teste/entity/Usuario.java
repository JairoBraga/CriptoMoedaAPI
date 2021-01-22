package com.workshop.teste.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = -6132789917389538455L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	private Long id;
	
	@Column(name = "NOME",unique = true)
	@NotNull
	private String nome;
	
	@Column(name = "USERNAME")
	@NotNull
	private String username;
	
	@Column(name = "CPF",unique = true)
	@NotNull
	private String cpf;
	
	@Column(name = "PASSWORD")
	@NotNull
	private String password;
	
	@Column(name = "CARTEIRA_ID")
	private Long carteira;

	public Usuario() {
	}

	public Usuario(Long id, String nome, String username, String cpf, String password, Long carteira) {
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.cpf = cpf;
		this.password = password;
		this.carteira = carteira;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getCarteira() {
		return carteira;
	}

	public void setCarteira(Long carteira) {
		this.carteira = carteira;
	}
}
