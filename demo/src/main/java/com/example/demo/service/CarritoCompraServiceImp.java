package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Articulo;

public class CarritoCompraServiceImp implements ICarritoCompraService{
	

	@Autowired
	private IBaseDatosService iBaseDatosService;
	
	private List<Articulo> cesta = new ArrayList<>();
	
	
	
	@Override
	public void limpiarCesta() {
		
		
		
		cesta.clear();
		
	}

	@Override
	public void addArticulo(Articulo articulo) {


		cesta.add(articulo);
		
	}

	@Override
	public Integer getNumArticulo() {
		
		

		return cesta.size();
	}

	
	
	@Override
	public List<Articulo> getArticulos() {
		
		return cesta;
	}

	@Override
	public Double totalPrice() {
		
		double total = 0D;
		
		for (Articulo articulo : cesta) {
			total = total + articulo.getPrecio();
		}
		
		return total;
	}

	@Override
	public Double calculadorDescuento(Double precio, Double porcentaje) {
		
		return precio - precio*porcentaje/100;
	}

	@Override
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje) {
		
		iBaseDatosService.iniciar();
		
		Articulo articulo = iBaseDatosService.buscarArticulo(idArticulo);
		
		if(Optional.ofNullable(articulo).isPresent()) {
			return calculadorDescuento(articulo.getPrecio(), porcentaje);
		}else {
			System.out.println("No se ha encontrado el articulo con id: " + idArticulo);
		}
		
		return 0D;
	}

	
	/*
	 * 
	 * 
	 * metodo insertar en carritocompraserviceimp
	 * 
	 * 	añadir articulo a la bbdd
	 *  añadir articulo a la cesta
	 *  en el test comprobar que el id del articulo añadido a la bbdd sea uno concreto
	 *  comprobar que el articulo se ha añadido a la lista
	 *  comprobar que el nombre y precio del articulo añadido a la lista tengan unos valores concretos
	 *  verificar que se llama a bbdd
	 *
	 */
	
	@Override
	public Integer insertar(Articulo articulo) {
		
		iBaseDatosService.iniciar();
		
		Integer idArticulo = iBaseDatosService.insertarArticulo(articulo);
		 cesta.add(articulo);
		 
		 System.out.println("la id es: " + idArticulo);
		
		 return idArticulo;
		
	}

	
	
}
