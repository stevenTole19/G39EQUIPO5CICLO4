package com.grupo39.almacenesdecadena.almacenes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo39.almacenesdecadena.almacenes.model.Producto;
import java.util.List;


public interface ProductoRepository extends MongoRepository<Producto, Integer> {
	
	List<Producto> findByCodigoproducto(Integer codigoproducto);
	
	List<Producto> findByNombreproducto(String nombreproducto);



}
