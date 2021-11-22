package com.example.grupo39.ciclo4.SuperLaGenerica.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "proveedores")
public class Proveedor {
	
	@Id
	private String id;
	private Integer nitproveedor;
	private String ciudadproveedor;
	private String direccionproveedor;	
	private String nombreproveedor;
	private String telefonoproveedor;
	
	public Integer getNitproveedor() {
		return nitproveedor;
	}
	public void setNitproveedor(Integer nitproveedor) {
		this.nitproveedor = nitproveedor;
	}
	public String getCiudadproveedor() {
		return ciudadproveedor;
	}
	public void setCiudadproveedor(String ciudadproveedor) {
		this.ciudadproveedor = ciudadproveedor;
	}
	public String getDireccionproveedor() {
		return direccionproveedor;
	}
	public void setDireccionproveedor(String direccionproveedor) {
		this.direccionproveedor = direccionproveedor;
	}
	public String getNombreproveedor() {
		return nombreproveedor;
	}
	public void setNombreproveedor(String nombreproveedor) {
		this.nombreproveedor = nombreproveedor;
	}
	public String getTelefonoproveedor() {
		return telefonoproveedor;
	}
	public void setTelefonoproveedor(String telefonoproveedor) {
		this.telefonoproveedor = telefonoproveedor;
	}
	public Proveedor(Integer nitproveedor, String ciudadproveedor, String direccionproveedor, String nombreproveedor,
			String telefonoproveedor) {
		
		this.nitproveedor = nitproveedor;
		this.ciudadproveedor = ciudadproveedor;
		this.direccionproveedor = direccionproveedor;
		this.nombreproveedor = nombreproveedor;
		this.telefonoproveedor = telefonoproveedor;
	}
	public Proveedor() {
		super();
	}
	

	

}
