package com.workshop.teste.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.teste.entity.CriptoMoeda;
import com.workshop.teste.exceptions.CoinNotFoundException;
import com.workshop.teste.repository.CriptoMoedaRepository;
import com.workshop.teste.request.CriptoMoedaRequest;
import com.workshop.teste.response.CriptoMoedaResponse;
import com.workshop.teste.service.CriptoMoedaService;

@Service
public class CriptoMoedaServiceImpl implements CriptoMoedaService{

	@Autowired
	private CriptoMoedaRepository repository;
	
	@Override
	public List<CriptoMoedaResponse> buscarTodasAsMoedas() {
		List<CriptoMoeda> listEntity = repository.findAll();
		List<CriptoMoedaResponse> response = listEntity.stream().map(x -> new CriptoMoedaResponse(x)).collect(Collectors.toList());
		return response;
	}
	@Override
	public void salvarMoeda(CriptoMoedaRequest request) {
		CriptoMoeda entity = new CriptoMoeda(null,request.getNomeDaMoeda(),request.getSimbolo(),request.getPreco());
		repository.save(entity);
	}
	@Override
	public CriptoMoedaResponse buscarMoedaPorId(Long id) throws CoinNotFoundException{
		CriptoMoeda entity = verifyId(id);
		CriptoMoedaResponse response = new CriptoMoedaResponse(entity);
		return response;
	}
	
	@Override
	public void updateMoeda(CriptoMoedaRequest request) throws CoinNotFoundException {
		CriptoMoeda entity = verifyId(request.getId());
		entity.setNomeDaMoeda(request.getNomeDaMoeda());
		entity.setPreco(request.getPreco());
		entity.setSimbolo(request.getSimbolo());
		repository.save(entity);
	}
	
	@Override
	public CriptoMoeda verifyId(Long id) throws CoinNotFoundException {
		return repository.findById(id).orElseThrow(() -> new CoinNotFoundException());
	}


	
}
