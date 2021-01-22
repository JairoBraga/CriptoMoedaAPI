package com.workshop.teste.service;

import org.springframework.stereotype.Service;

import com.workshop.teste.response.CarteiraResponse;

@Service
public interface CarteiraService {
	public CarteiraResponse criarCarteira(Long idUser);

	public CarteiraResponse buscarCarteiraPorId(Long id);

}

