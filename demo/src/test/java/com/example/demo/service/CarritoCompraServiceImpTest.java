package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.model.Articulo;

@RunWith(MockitoJUnitRunner.class)
public class CarritoCompraServiceImpTest {
	

	@InjectMocks
	private CarritoCompraServiceImp carritoCompraServiceImp = new CarritoCompraServiceImp();
	
	@Mock
	IBaseDatosService iBaseDatosService;

	@Test
	public void testLimpiarCesta() {
		
		carritoCompraServiceImp.addArticulo(new Articulo("Camiseta", 15.99));
		assertFalse(carritoCompraServiceImp.getArticulos().isEmpty());
		carritoCompraServiceImp.limpiarCesta();
		assertTrue(carritoCompraServiceImp.getArticulos().isEmpty());
		
		
	
	}

	@Test
	public void testAddArticulo() {
		
		carritoCompraServiceImp.addArticulo(new Articulo("Pantalon", 24.60));
		assertFalse(carritoCompraServiceImp.getArticulos().isEmpty());
		
		
		
		
	}

	@Test
	public void testGetNumArticulo() {
		
		carritoCompraServiceImp.addArticulo(new Articulo("Impresora", 230.99));
		carritoCompraServiceImp.addArticulo(new Articulo("Monitor", 410.39));
		carritoCompraServiceImp.addArticulo(new Articulo("Impresora", 230.99));
		assertEquals(3, carritoCompraServiceImp.getNumArticulo());
		
	}

	@Test
	public void testGetArticulos() {
		
		carritoCompraServiceImp.addArticulo(new Articulo("Impresora", 230.99));
		carritoCompraServiceImp.addArticulo(new Articulo("Monitor", 410.39));
		carritoCompraServiceImp.addArticulo(new Articulo("Impresora", 230.99));
		assertEquals(carritoCompraServiceImp.getArticulos().size(), carritoCompraServiceImp.getNumArticulo());
		
	}

	@Test
	public void testTotalPrice() {
		
		carritoCompraServiceImp.addArticulo(new Articulo("Impresora", 230.99));
		carritoCompraServiceImp.addArticulo(new Articulo("Monitor", 410.39));
		carritoCompraServiceImp.addArticulo(new Articulo("Impresora", 230.99));
		assertEquals(872.37, carritoCompraServiceImp.totalPrice());
		
		
		
	
	}

	@Test
	public void testCalculadorDescuento() {
		
		carritoCompraServiceImp.addArticulo(new Articulo("Impresora", 230.00));
		assertEquals(207.00, carritoCompraServiceImp.calculadorDescuento(230.00, 10D));
		
		
		
	}
	
	@Test
	public void testAplicarDescuento() {
		
		
		Articulo articulo = new Articulo("Impresora", 20.00);
		when(iBaseDatosService.buscarArticulo(any(Integer.class))).thenReturn(articulo);
		Double res = carritoCompraServiceImp.aplicarDescuento(1, 10D);
		assertEquals(18D, res);
		
		
	}
	
	@Test
	public void testInsertar() {
	
		
		
		Articulo articulo = new Articulo("teclado", 20.00);
		
		Articulo articulo2 = new Articulo("raton", 15.00);
		when(this.iBaseDatosService.insertarArticulo(articulo)).thenReturn(2);
		
		Integer idArticulo = carritoCompraServiceImp.insertar(articulo);
		
		assertEquals(2, idArticulo);
		
	}
	
	

}
