package com.grupo39.almacenesdecadena.almacenes.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.grupo39.almacenesdecadena.almacenes.model.Usuario;


public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	//Hacer una busqueda por usuario
		List<Usuario> findByUsername(String username);
		
		//Hacer una busqueda por nombre
		
		//List<Usuario> findByNombre_completo(String nombre_completo);
}
