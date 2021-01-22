package com.workshop.teste.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.workshop.teste.entity.CriptoMoeda;
import com.workshop.teste.exceptions.CoinNotFoundException;
import com.workshop.teste.request.CriptoMoedaRequest;
import com.workshop.teste.response.CriptoMoedaResponse;

@Service
public interface CriptoMoedaService{
	public List<CriptoMoedaResponse> buscarTodasAsMoedas();
	
	public CriptoMoedaResponse buscarMoedaPorId(Long id) throws Exception;
	
	public void updateMoeda(CriptoMoedaRequest request) throws CoinNotFoundException;

	public void salvarMoeda(CriptoMoedaRequest request);

	public CriptoMoeda verifyId(Long id) throws CoinNotFoundException;
}
