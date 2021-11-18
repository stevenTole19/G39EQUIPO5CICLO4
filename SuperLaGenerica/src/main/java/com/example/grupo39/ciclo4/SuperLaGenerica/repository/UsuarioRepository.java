package com.example.grupo39.ciclo4.SuperLaGenerica.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.grupo39.ciclo4.SuperLaGenerica.modelo.Usuario;

public interface UsuarioRepository extends  MongoRepository<Usuario, String> {
	

	List<Usuario> findByUsername(String username);
	
	List<Usuario> findByNombrecompleto(String nombrecompleto);

}