package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.Articulo;

@Service
public class BaseDatosServiceImp implements IBaseDatosService{
	
	
	private Map<Integer,Articulo> baseDatos;

	@Override
	public void iniciar() {
		baseDatos = new HashMap<>();
		baseDatos.put(1, new Articulo("monitor1", 200.00));
		baseDatos.put(2, new Articulo("monitor2", 300.00));
		baseDatos.put(3, new Articulo("monitor3", 400.00));
		baseDatos.put(4, new Articulo("monitor4", 500.00));
		baseDatos.put(5, new Articulo("monitor5", 100.00));
		
		
	}

	@Override
	public Integer insertarArticulo(Articulo articulo) {
		
		baseDatos.put(baseDatos.size()+1, articulo);
		
		
		return baseDatos.size();
	}

	@Override
	public Articulo buscarArticulo(Integer identificador) {
		
		
		return baseDatos.get(identificador);
	}


	
	

}
