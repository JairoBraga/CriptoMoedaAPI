package com.workshop.teste.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.workshop.teste.entity.Usuario;

import io.jsonwebtoken.Claims;
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

	public Boolean validarToken(String token) {
		
		try {
		Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
		return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		
		return Long.parseLong(claims.getSubject());
	}

}
