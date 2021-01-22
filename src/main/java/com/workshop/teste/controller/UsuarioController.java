package com.workshop.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.teste.exceptions.UserNotFoundException;
import com.workshop.teste.request.UsuarioRequest;
import com.workshop.teste.response.CarteiraResponse;
import com.workshop.teste.response.UsuarioResponse;
import com.workshop.teste.service.CarteiraService;
import com.workshop.teste.service.UsuarioService;

@RestController
@RequestMapping(value = "/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private CarteiraService carteiraService;
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioResponse> buscarTodosOsUsuarios(){
		return service.buscarUsuarios();
	}
	
	@PostMapping(value = "/criar_conta")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarUsuarios(@RequestBody UsuarioRequest request) {
		service.salvarUsuario(request);
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarDados(@PathVariable(value = "id") Long id, @RequestBody UsuarioRequest request) throws UserNotFoundException {
		service.updateUsuario(request, id);
	}
	
	@PutMapping(value = "/{id}/criarCarteira")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void criarCarteira(@PathVariable(value = "id") Long id) throws UserNotFoundException {
		CarteiraResponse carteira = carteiraService.criarCarteira(id);
		service.AdicionarCarteira(carteira.getId(), id);
	}
	
}
