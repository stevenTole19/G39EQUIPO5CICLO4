package com.example.grupo39.ciclo4.SuperLaGenerica.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuario {
	@Id
	private String id;
	private String username;
	private String password;
	private String nombrecompleto;
	private String email;
	
	
	public Usuario(String username, String password, String nombrecompleto, String email) {
		super();
		this.username = username;
		this.password = password;
		this.nombrecompleto = nombrecompleto;
		this.email = email;
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
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
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
	