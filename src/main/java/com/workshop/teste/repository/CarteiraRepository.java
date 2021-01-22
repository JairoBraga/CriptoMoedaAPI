package com.workshop.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workshop.teste.entity.Carteira;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long>{

}
