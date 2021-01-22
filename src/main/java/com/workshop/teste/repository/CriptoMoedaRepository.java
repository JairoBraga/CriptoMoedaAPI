package com.workshop.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workshop.teste.entity.CriptoMoeda;

@Repository
public interface CriptoMoedaRepository extends JpaRepository<CriptoMoeda, Long> {

}
