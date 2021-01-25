package com.workshop.teste.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.workshop.teste.entity.Usuario;
import com.workshop.teste.exceptions.UserNotFoundException;
import com.workshop.teste.service.UsuarioService;
import com.workshop.teste.serviceImpl.TokenService;

public class AutenticacaoTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	
	private UsuarioService userService;
	
	public AutenticacaoTokenFilter(TokenService tokenService, UsuarioService userService) {
		super();
		this.tokenService = tokenService;
		this.userService = userService;
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = recuperarToken(request);
		Boolean validacao = tokenService.validarToken(token);
		
		if(validacao)
			try {
				autenticar(token);
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			}
		
		filterChain.doFilter(request, response);
	}


	private void autenticar(String token) throws UserNotFoundException {
		Long idLogado = tokenService.getIdUsuario(token);
		Usuario usuario = userService.buscaUsuarioId(idLogado);
		Authentication authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}


	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
			
		return token.substring(7,token.length());
	}
	

}
