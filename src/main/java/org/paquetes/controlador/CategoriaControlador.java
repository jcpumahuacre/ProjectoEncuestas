package org.paquetes.controlador;

import org.paquetes.servicios.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaControlador {
	@Autowired
	private CategoriaServicio categoriaServicio;
	
	@GetMapping("/categorias")
	public String datos(){
		return "Hello "+categoriaServicio.findAll().toString();
	}
}
