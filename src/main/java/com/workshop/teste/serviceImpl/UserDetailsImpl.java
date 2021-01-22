package com.workshop.teste.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
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
		List<GrantedAuthority>	listAuth = AuthorityUtils.createAuthorityList("USER");
		PasswordEncoder passwordEncoder =
			    PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return new User(user.getUsername(),passwordEncoder.encode(user.getPassword()),listAuth);
	}

}
