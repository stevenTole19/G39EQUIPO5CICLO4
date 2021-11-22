package com.example.grupo39.ciclo4.SuperLaGenerica.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.grupo39.ciclo4.SuperLaGenerica.modelo.Proveedor;


public interface ProveedorRepository extends MongoRepository<Proveedor, String> {
	
	List<Proveedor> findByNombreproveedor(String nombreproveedor);
	List<Proveedor> findByNitproveedor(Integer nitproveeedor);
	

}
