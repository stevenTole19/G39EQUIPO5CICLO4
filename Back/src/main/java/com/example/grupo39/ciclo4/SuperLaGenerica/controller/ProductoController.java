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


import com.example.grupo39.ciclo4.SuperLaGenerica.modelo.Producto;
import com.example.grupo39.ciclo4.SuperLaGenerica.repository.ProductoRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

public class ProductoController {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> getAllProductos(@RequestParam(required = false) String nombreproducto) {
		try {
			List<Producto> productos = new ArrayList<Producto>();

			if (nombreproducto == null) {
				productoRepository.findAll().forEach(productos::add);
			} else {
				productoRepository.findByNombreproducto(nombreproducto).forEach(productos::add);
			}

			if (productos.isEmpty()) {
				//error 204
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			//error 201
			return new ResponseEntity<>(productos, HttpStatus.OK);
		} catch (Exception e) {
			//error 500
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	

	
	
	 @GetMapping("/getcodigoproductos/{codigoproducto}")
	 public ResponseEntity<List<Producto>> getProductoByCodigo(@PathVariable("codigoproducto") Integer codigoproducto) {
		 
		 try {
		    	System.out.println(codigoproducto);
		    	List<Producto> productos = productoRepository.findByCodigoproducto(codigoproducto);

		      if (productos.isEmpty()) {
		    	  //no encontre info
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      //encontre info
		      return new ResponseEntity<>(productos, HttpStatus.OK);
		    } catch (Exception e) {
		    	//error algo paso
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
	 
	 @PostMapping("/productos")
	  public ResponseEntity<Producto> createProductos(@RequestBody Producto prod) {
	    try {
	      Producto _producto = productoRepository.save(new Producto(prod.getCodigoproducto(), prod.getNombreproducto(), prod.getNitproveedor(), prod.getPreciocompra(), prod.getIvacompra(), prod.getPrecioventa()));
	      //si lo cree guardo en 200
	      return new ResponseEntity<>(_producto, HttpStatus.CREATED);
	    } catch (Exception e) {
		      //sino lo pude crear error 500
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 


	  @PutMapping("/productos/{id}")
	  public ResponseEntity<Producto> updateProductos(@PathVariable("id") String id, @RequestBody Producto prod) {
	    Optional<Producto> productoData = productoRepository.findById(id);

	    if (productoData.isPresent()) {
	      Producto _producto = productoData.get();
	      _producto.setCodigoproducto(prod.getCodigoproducto());
	      _producto.setNombreproducto(prod.getNombreproducto());
	      _producto.setNitproveedor(prod.getNitproveedor());
	      _producto.setPreciocompra(prod.getPreciocompra());
	      _producto.setIvacompra(prod.getIvacompra());
	      _producto.setPrecioventa(prod.getPrecioventa());	      
	      return new ResponseEntity<>(productoRepository.save(_producto), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  
	  @DeleteMapping("/productos/{id}")
	  public ResponseEntity<HttpStatus> deleteProductos(@PathVariable("id") String id) {
	    try {
	      productoRepository.deleteById(id);
	      //si lo borre, retorno 200
	      System.out.println(id);				
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	    	//sino lo borre, retorno 500
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  


	  @DeleteMapping("/productos")
	  public ResponseEntity<HttpStatus> deleteAllProductos() {
	    try {
	      productoRepository.deleteAll();
	      //si los borre todos 201
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	    	//sino los borre todos 500
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  


	  @GetMapping("/getnombreproducto/{nombreproducto}")
	  public ResponseEntity<List<Producto>> findByNombreProducto(@PathVariable("nombreproducto") String nombreproducto) {
	    try {
	    	System.out.println(nombreproducto);
	    	List<Producto> productos = productoRepository.findByNombreproducto(nombreproducto);

	      if (productos.isEmpty()) {
	    	  //no encontre info
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      //encontre info
	      return new ResponseEntity<>(productos, HttpStatus.OK);
	    } catch (Exception e) {
	    	//error algo paso
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  
}


