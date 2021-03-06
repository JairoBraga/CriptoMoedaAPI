package com.workshop.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.teste.entity.Carteira;
import com.workshop.teste.entity.Usuario;
import com.workshop.teste.exceptions.UserNotFoundException;
import com.workshop.teste.request.UsuarioRequest;
import com.workshop.teste.response.UsuarioResponse;
import com.workshop.teste.service.CarteiraService;
import com.workshop.teste.service.UsuarioService;

@RestController
@RequestMapping()
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private CarteiraService carteiraService;
	
	@GetMapping(value = "/minha_conta")
	public ResponseEntity<UsuarioResponse> buscarUsuario(@AuthenticationPrincipal UserDetails userDetail) throws UserNotFoundException {
		Usuario user = service.getByUsername(userDetail.getUsername());
		UsuarioResponse response = new UsuarioResponse(user);
		return new ResponseEntity<UsuarioResponse>(response,HttpStatus.OK);
	}
	
	@PostMapping(value = "/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarUsuarios(@RequestBody @Validated UsuarioRequest request) {
		service.salvarUsuario(request);
	}
	
	@PutMapping(value = "/minha_conta/atualizar_dados")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarDados(@AuthenticationPrincipal UserDetails userDetail, @RequestBody UsuarioRequest request) throws UserNotFoundException {
		Usuario user = service.getByUsername(userDetail.getUsername());
		service.updateUsuario(request,user.getId());
		System.out.println("Atualizado");
	}
	
	@PostMapping(value = "/minha_conta/criar_carteira")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void criarCarteira(@AuthenticationPrincipal UserDetails userDetail) throws UserNotFoundException {
		Usuario user = service.getByUsername(userDetail.getUsername());
		Carteira carteira = carteiraService.criarCarteira();
		service.AdicionarCarteira(carteira, user.getId());
	}	
}