package com.workshop.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workshop.teste.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

}
