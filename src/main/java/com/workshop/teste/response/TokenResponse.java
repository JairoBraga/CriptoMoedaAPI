package com.workshop.teste.response;

public class TokenResponse {

	private String Token;
	private String tipo;
	
	
	public TokenResponse(String token, String tipo) {
		Token = token;
		this.tipo = tipo;
	}
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
