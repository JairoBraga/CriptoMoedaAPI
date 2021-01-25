package com.workshop.teste.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.workshop.teste.entity.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	@Value("${jwt.expiration}")
	private String expiration;
	
	@Value("${jwt.secret}")
	private String secret;
	
	public String gerarToken(Authentication authentication) {
		Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataLimit = new Date(hoje.getTime() + Long.parseLong(expiration));
		return Jwts.builder()
				.setIssuer("Api cripto")
				.setSubject(usuarioLogado.getId().toString())
				.setIssuedAt(hoje )
				.setExpiration(dataLimit)
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}

}
