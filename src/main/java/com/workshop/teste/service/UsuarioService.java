package com.workshop.teste.service;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.workshop.teste.entity.Usuario;
import com.workshop.teste.exceptions.UserNotFoundException;
import com.workshop.teste.request.UsuarioRequest;
import com.workshop.teste.response.UsuarioResponse;

@Service
public interface UsuarioService {
	public List<UsuarioResponse> buscarUsuarios();
	
	public Usuario getByUsername(String username) throws UsernameNotFoundException;
	
	public void salvarUsuario(UsuarioRequest user);

	public void updateUsuario(UsuarioRequest user, Long id) throws UserNotFoundException;

	public Usuario buscaUsuarioId(Long id) throws UserNotFoundException;
	
	public void AdicionarCarteira(Long idCarteira,Long id) throws UserNotFoundException;
}
