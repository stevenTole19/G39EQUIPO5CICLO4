package com.example.grupo39.ciclo4.SuperLaGenerica.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.grupo39.ciclo4.SuperLaGenerica.modelo.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	//Hacer una busqueda por usuario
		List<Usuario> findByUsername(String username);
		List<Usuario> findByCedula(Integer cedula);
		
		//Hacer una busqueda por nombre
		
		//List<Usuario> findByNombre_completo(String nombre_completo);
}