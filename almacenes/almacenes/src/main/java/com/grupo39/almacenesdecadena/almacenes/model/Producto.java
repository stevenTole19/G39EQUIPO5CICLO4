package com.grupo39.almacenesdecadena.almacenes.model;


import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")

public class Producto {
	
	@Id
	private Integer codigoproducto;
	private Double ivacompra;
	private Integer nitproveedor;
	private String nombreproducto;
	private Double preciocompra;
	private Double precioventa;

	public Producto(Integer codigoproducto,  Double ivacompra, Integer nitproveedor,String nombreproducto,Double preciocompra,Double precioventa) {
		this.codigoproducto = codigoproducto;
		this.ivacompra = ivacompra;
		this.nitproveedor = nitproveedor;
		this.preciocompra = preciocompra;
		this.precioventa = precioventa;
	}

	
	public Integer getCodigoproducto() {
		return codigoproducto;
	}

	public void setCodigoproducto(Integer codigoproducto) {
		this.codigoproducto = codigoproducto;
	}

	public Double getIvacompra() {
		return ivacompra;
	}

	public void setIvacompra(Double ivacompra) {
		this.ivacompra = ivacompra;
	}

	public Integer getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(Integer nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public Double getPreciocompra() {
		return preciocompra;
	}

	public void setPreciocompra(Double preciocompra) {
		this.preciocompra = preciocompra;
	}

	public Double getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(Double precioventa) {
		this.precioventa = precioventa;
	}
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	

	
}