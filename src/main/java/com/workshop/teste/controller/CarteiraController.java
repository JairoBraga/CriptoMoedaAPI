package com.workshop.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.teste.entity.Usuario;
import com.workshop.teste.response.CarteiraResponse;
import com.workshop.teste.service.CarteiraService;
import com.workshop.teste.service.UsuarioService;

@RestController
@RequestMapping(value = "/carteira")
public class CarteiraController {
	
	@Autowired
	private CarteiraService service;
	
	@Autowired
	private UsuarioService userService;
		
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public CarteiraResponse buscarCarteiraPorId(@AuthenticationPrincipal UserDetails userDetail) {
		Usuario user = userService.getByUsername(userDetail.getUsername());
		return service.buscarCarteiraPorId(user.getCarteira());
	}
}
