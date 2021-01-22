package com.workshop.teste.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.teste.entity.Carteira;
import com.workshop.teste.repository.CarteiraRepository;
import com.workshop.teste.response.CarteiraResponse;
import com.workshop.teste.service.CarteiraService;

@Service
public class CarteiraServiceImpl implements CarteiraService{
	
	@Autowired
	private CarteiraRepository repository;

	@Override
	public CarteiraResponse criarCarteira(Long idUser) {
		Carteira carteira = new Carteira(idUser);
		Carteira entity = repository.save(carteira);
		CarteiraResponse response = new CarteiraResponse(entity);
		return response;
	}

	@Override
	public CarteiraResponse buscarCarteiraPorId(Long id) {
		Optional<Carteira> entity = repository.findById(id);
		CarteiraResponse response = new CarteiraResponse(entity.get());
		return response;
	}
	

}
