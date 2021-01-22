package com.workshop.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.workshop.teste.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

	@Query(value = "SELECT us.* FROM usuarios as us WHERE us.username = ?1", nativeQuery = true)
	public Usuario getByUsername(String username) throws UsernameNotFoundException;
}
