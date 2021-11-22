package com.example.grupo39.ciclo4.SuperLaGenerica.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.grupo39.ciclo4.SuperLaGenerica.modelo.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {
	
	//Hacer una busqueda por usuario
		List<Producto> findByNombreproducto(String nombreproducto);
		List<Producto> findByCodigoproducto(Integer codigoproducto);
		
		//Hacer una busqueda por nombre
		
		//List<Usuario> findByNombre_completo(String nombre_completo);
}