package com.example.demo.service;

import com.example.demo.model.Articulo;

public interface IBaseDatosService {

	public void iniciar();

	public Integer insertarArticulo(Articulo articulo);

	public Articulo buscarArticulo(Integer identificador);

}
