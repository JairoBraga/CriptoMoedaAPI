package com.workshop.teste.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.workshop.teste.entity.Carteira;
import com.workshop.teste.entity.Usuario;
import com.workshop.teste.exceptions.UserNotFoundException;
import com.workshop.teste.repository.UsuarioRepository;
import com.workshop.teste.request.UsuarioRequest;
import com.workshop.teste.response.UsuarioResponse;
import com.workshop.teste.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public List<UsuarioResponse> buscarUsuarios(){
		List<Usuario> ListUsuario = repository.findAll();
		List<UsuarioResponse> ListResponse = ListUsuario.stream().map(x -> new UsuarioResponse(x)).collect(Collectors.toList());
		return ListResponse;
	}

	@Override
	public void salvarUsuario(UsuarioRequest req) {
		BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
		Usuario entity = new Usuario(null,req.getNome(),req.getUsername(),req.getCpf(),enc.encode(req.getPassword()),null);
		repository.save(entity);
	}

	@Override
	public void updateUsuario(UsuarioRequest user, Long id) throws UserNotFoundException{
		BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
		Usuario entity = buscaUsuarioId(id);
		entity.setNome(user.getNome());
		if(user.getPassword() != null)
		entity.setPassword(enc.encode(user.getPassword()));
		repository.save(entity);
	}

	@Override
	public Usuario buscaUsuarioId(Long id) throws UserNotFoundException {
		return repository.findById(id).orElseThrow(() -> new UserNotFoundException());
	}

	@Override
	public void AdicionarCarteira(Carteira carteira,Long id) throws UserNotFoundException {
		Usuario entity = buscaUsuarioId(id);
		entity.setCarteira(carteira);
		repository.save(entity);
	}

	@Override
	public Usuario getByUsername(String username) throws UsernameNotFoundException {
		Usuario user = repository.getByUsername(username);
		return user;
	}

}
