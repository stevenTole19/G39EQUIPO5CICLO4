package com.example.grupo39.ciclo4.SuperLaGenerica.modelo;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "productos")
public class Producto {
	
	@Id
	private String id;
	private Integer codigoproducto;
	private String nombreproducto;
	private Integer nitproveedor;
	private Double preciocompra;
	private Double ivacompra;
	private Double precioventa;
	
	
	
	public Producto() {		
		// TODO Auto-generated constructor stub
	
	}
	
	
	
	public Producto(Integer codigoproducto, String nombreproducto, Integer nitproveedor, Double preciocompra,
			Double ivacompra, Double precioventa) {
		
		this.codigoproducto = codigoproducto;
		this.nombreproducto = nombreproducto;
		this.nitproveedor = nitproveedor;
		this.preciocompra = preciocompra;
		this.ivacompra = ivacompra;
		this.precioventa = precioventa;
	}



	public Integer getCodigoproducto() {
		return codigoproducto;
	}
	public void setCodigoproducto(Integer codigoproducto) {
		this.codigoproducto = codigoproducto;
	}
	public String getNombreproducto() {
		return nombreproducto;
	}
	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}
	public Integer getNitproveedor() {
		return nitproveedor;
	}
	public void setNitproveedor(Integer nitproveedor) {
		this.nitproveedor = nitproveedor;
	}
	public Double getPreciocompra() {
		return preciocompra;
	}
	public void setPreciocompra(Double preciocompra) {
		this.preciocompra = preciocompra;
	}
	public Double getIvacompra() {
		return ivacompra;
	}
	public void setIvacompra(Double ivacompra) {
		this.ivacompra = ivacompra;
	}
	public Double getPrecioventa() {
		return precioventa;
	}
	public void setPrecioventa(Double precioventa) {
		this.precioventa = precioventa;
	}
	
	

}
