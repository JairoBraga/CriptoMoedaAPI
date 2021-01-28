package com.workshop.teste.service;

import org.springframework.stereotype.Service;

import com.workshop.teste.entity.Carteira;

@Service
public interface CarteiraService {
	public Carteira criarCarteira();

	public Carteira buscarCarteiraPorId(Long id);

}

