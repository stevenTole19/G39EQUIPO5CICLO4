package com.example.grupo39.ciclo4.SuperLaGenerica.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.grupo39.ciclo4.SuperLaGenerica.modelo.Proveedor;
import com.example.grupo39.ciclo4.SuperLaGenerica.repository.ProveedorRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

public class ProveedorController {
	@Autowired
	ProveedorRepository proveedorRepository;
	

	@GetMapping("/proveedores")
	public ResponseEntity<List<Proveedor>> getAllProveedores(@RequestParam(required = false) String nombreproveedor) {
		try {
			List<Proveedor> proveedores = new ArrayList<Proveedor>();

			if (nombreproveedor == null) {
				proveedorRepository.findAll().forEach(proveedores::add);
			} else {
				proveedorRepository.findByNombreproveedor(nombreproveedor).forEach(proveedores::add);
			}

			if (proveedores.isEmpty()) {
				//error 204
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			//error 201
			return new ResponseEntity<>(proveedores, HttpStatus.OK);
		} catch (Exception e) {
			//error 500
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	 @GetMapping("/getnitproveedor/{nitproveedor}")
	 public ResponseEntity<List<Proveedor>> getProveedorByNit(@PathVariable("nitproveedor") Integer nitproveedor) {
		 
		 try {
		    	System.out.println(nitproveedor);
		    	List<Proveedor> proveedores = proveedorRepository.findByNitproveedor(nitproveedor);

		      if (proveedores.isEmpty()) {
		    	  //no encontre info
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      //encontre info
		      return new ResponseEntity<>(proveedores, HttpStatus.OK);
		    } catch (Exception e) {
		    	//error algo paso
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
	 

	  @PostMapping("/proveedores")
	  public ResponseEntity<Proveedor> createProveedores(@RequestBody Proveedor prov) {
	    try {
	      Proveedor _proveedor = proveedorRepository.save(new Proveedor(prov.getNitproveedor(), prov.getCiudadproveedor(), prov.getDireccionproveedor(), prov.getNombreproveedor(), prov.getTelefonoproveedor()));
	      //si lo cree guardo en 200
	      return new ResponseEntity<>(_proveedor, HttpStatus.CREATED);
	    } catch (Exception e) {
		      //sino lo pude crear error 500
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @PutMapping("/proveedores/{id}")
	  public ResponseEntity<Proveedor> updateProveedor(@PathVariable("id") String id, @RequestBody Proveedor prov) {
	    Optional<Proveedor> proveedorData = proveedorRepository.findById(id);

	    if (proveedorData.isPresent()) {
	      Proveedor _proveedor = proveedorData.get();
	      _proveedor.setNitproveedor(prov.getNitproveedor());
	      _proveedor.setCiudadproveedor(prov.getCiudadproveedor());
	      _proveedor.setDireccionproveedor(prov.getDireccionproveedor());
	      _proveedor.setNombreproveedor(prov.getNombreproveedor());
	      _proveedor.setTelefonoproveedor(prov.getTelefonoproveedor());
	      return new ResponseEntity<>(proveedorRepository.save(_proveedor), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/proveedores/{id}")
	  public ResponseEntity<HttpStatus> deleteProveedores(@PathVariable("id") String id) {
	    try {
	      proveedorRepository.deleteById(id);
	      //si lo borre, retorno 200
	      System.out.println(id);				
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	    	//sino lo borre, retorno 500
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @DeleteMapping("/proveedores")
	  public ResponseEntity<HttpStatus> deleteAllProveedores() {
	    try {
	      proveedorRepository.deleteAll();
	      //si los borre todos 201
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	    	//sino los borre todos 500
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @GetMapping("/getnombreproveedor/{nombreproveedor}")
	  public ResponseEntity<List<Proveedor>> findByNombreproveedor(@PathVariable("nombreproveedor") String nombreproveedor) {
	    try {
	    	System.out.println(nombreproveedor);
	    	List<Proveedor> proveedores = proveedorRepository.findByNombreproveedor(nombreproveedor);

	      if (proveedores.isEmpty()) {
	    	  //no encontre info
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      //encontre info
	      return new ResponseEntity<>(proveedores, HttpStatus.OK);
	    } catch (Exception e) {
	    	//error algo paso
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
