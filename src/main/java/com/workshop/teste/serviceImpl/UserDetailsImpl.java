package com.workshop.teste.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.workshop.teste.entity.Usuario;
import com.workshop.teste.service.UsuarioService;

@Component
public class UserDetailsImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario user = service.getByUsername(username);
		return user;
	}

}
