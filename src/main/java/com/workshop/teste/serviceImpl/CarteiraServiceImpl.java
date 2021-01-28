package com.workshop.teste.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.teste.entity.Carteira;
import com.workshop.teste.repository.CarteiraRepository;
import com.workshop.teste.service.CarteiraService;

@Service
public class CarteiraServiceImpl implements CarteiraService{
	
	@Autowired
	private CarteiraRepository repository;

	@Override
	public Carteira criarCarteira() {
		Carteira entity = repository.save( new Carteira());
		return entity;
	}

	@Override
	public Carteira buscarCarteiraPorId(Long id) {
		Optional<Carteira> entity = repository.findById(id);
		return entity.get();
	}
	

}
