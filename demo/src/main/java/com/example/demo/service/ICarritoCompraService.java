package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Articulo;

public interface ICarritoCompraService {
	
	public void limpiarCesta();
	
	public void addArticulo (Articulo articulo);
	
	public Integer getNumArticulo() ;
	
	public List<Articulo> getArticulos ();
	
	public Double totalPrice();
	
	public Double calculadorDescuento (Double precio, Double porcentaje);
	
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje);
	
	public Integer insertar (Articulo articulo);
	
	
	
	
	

}
