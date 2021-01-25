package com.workshop.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.teste.form.FormLogin;
import com.workshop.teste.response.TokenResponse;
import com.workshop.teste.serviceImpl.TokenService;

@RestController
@RequestMapping(value =  "/auth")
public class AutenticacaoController{
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@PostMapping
	public ResponseEntity<TokenResponse> autenticacao(@RequestBody FormLogin formLogin){
		
		UsernamePasswordAuthenticationToken dadosLogin = formLogin.converter();
		try {
		Authentication authentication = authManager.authenticate(dadosLogin);
		String token = tokenService.gerarToken(authentication);
		return ResponseEntity.ok(new TokenResponse(token, "Bearer"));	
		}
		catch(AuthenticationException e ) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
}
