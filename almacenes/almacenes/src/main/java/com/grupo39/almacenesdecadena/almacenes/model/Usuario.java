package com.grupo39.almacenesdecadena.almacenes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuarios")

public class Usuario {
	
	@Id
	private String id;
	private String username;
	private String password;
	private String nombre_completo;
	private String email;		
	
	public Usuario(String username, String password, String nombre_completo, String email) {
		super();
		this.username = username;
		this.password = password;
		this.nombre_completo = nombre_completo;
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
