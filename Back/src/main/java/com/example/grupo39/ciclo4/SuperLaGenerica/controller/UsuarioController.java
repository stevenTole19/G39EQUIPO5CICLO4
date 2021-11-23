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


import com.example.grupo39.ciclo4.SuperLaGenerica.modelo.Usuario;
import com.example.grupo39.ciclo4.SuperLaGenerica.repository.UsuarioRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	

	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getAllUsuarios(@RequestParam(required = false) String username) {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();

			if (username == null) {
				usuarioRepository.findAll().forEach(usuarios::add);
			} else {
				usuarioRepository.findByUsername(username).forEach(usuarios::add);
			}

			if (usuarios.isEmpty()) {
				//error 204
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			//error 201
			return new ResponseEntity<>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			//error 500
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	 @GetMapping("/getcedulausuarios/{cedula}")
	 public ResponseEntity<List<Usuario>> getUsuariosByCedula(@PathVariable("cedula") Integer cedula) {
		 
		 try {
		    	System.out.println(cedula);
		    	List<Usuario> usuarios = usuarioRepository.findByCedula(cedula);

		      if (usuarios.isEmpty()) {
		    	  //no encontre info
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      //encontre info
		      return new ResponseEntity<>(usuarios, HttpStatus.OK);
		    } catch (Exception e) {
		    	//error algo paso
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
	 

	  @PostMapping("/usuarios")
	  public ResponseEntity<Usuario> createUsuarios(@RequestBody Usuario user) {
	    try {
	      Usuario _usuario = usuarioRepository.save(new Usuario(user.getUsername(),user.getPassword(),user.getNombre_completo(),user.getEmail(), user.getCedula()));
	      //si lo cree guardo en 200
	      return new ResponseEntity<>(_usuario, HttpStatus.CREATED);
	    } catch (Exception e) {
		      //sino lo pude crear error 500
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @PutMapping("/usuarios/{id}")
	  public ResponseEntity<Usuario> updateUsuarios(@PathVariable("id") String id, @RequestBody Usuario user) {
	    Optional<Usuario> usuarioData = usuarioRepository.findById(id);

	    if (usuarioData.isPresent()) {
	      Usuario _usuario = usuarioData.get();
	      _usuario.setUsername(user.getUsername());
	      _usuario.setPassword(user.getPassword());
	      _usuario.setNombre_completo(user.getNombre_completo());
	      _usuario.setEmail(user.getEmail());
	      _usuario.setCedula(user.getCedula());
	      return new ResponseEntity<>(usuarioRepository.save(_usuario), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/usuarios/{id}")
	  public ResponseEntity<HttpStatus> deleteUsuarios(@PathVariable("id") String id) {
	    try {
	      usuarioRepository.deleteById(id);
	      //si lo borre, retorno 200
	      System.out.println(id);				
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	    	//sino lo borre, retorno 500
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @DeleteMapping("/usuarios")
	  public ResponseEntity<HttpStatus> deleteAllUsuarioss() {
	    try {
	      usuarioRepository.deleteAll();
	      //si los borre todos 201
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	    	//sino los borre todos 500
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @GetMapping("/getusernameusuarios/{username}")
	  public ResponseEntity<List<Usuario>> findByUsername(@PathVariable("username") String username) {
	    try {
	    	System.out.println(username);
	    	List<Usuario> usuarios = usuarioRepository.findByUsername(username);

	      if (usuarios.isEmpty()) {
	    	  //no encontre info
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      //encontre info
	      return new ResponseEntity<>(usuarios, HttpStatus.OK);
	    } catch (Exception e) {
	    	//error algo paso
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  
}