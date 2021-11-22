package com.example.grupo39.ciclo4.SuperLaGenerica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import com.example.grupo39.ciclo4.SuperLaGenerica.modelo.Cliente;

public interface ClientesRepository extends MongoRepository<Cliente, String> {

     List<Cliente> findByNombrecliente(String nombrecliente);
     List<Cliente> findByCedulacliente(Integer cedulacliente);

}