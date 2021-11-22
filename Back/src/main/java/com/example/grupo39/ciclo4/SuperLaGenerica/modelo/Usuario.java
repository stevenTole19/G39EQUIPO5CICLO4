package com.example.grupo39.ciclo4.SuperLaGenerica.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")

public class Usuario {
	
	@Id
	private String id;
	private String username;
	private String password;
	private String nombre_completo;
	private String email;	
	private Integer cedula;
	
	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}

	public Usuario(String username, String password, String nombre_completo, String email, Integer cedula) {
		super();
		this.username = username;
		this.password = password;
		this.nombre_completo = nombre_completo;
		this.email = email;
		this.cedula = cedula;
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
