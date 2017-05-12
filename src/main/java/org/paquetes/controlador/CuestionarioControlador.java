package org.paquetes.controlador;

import org.paquetes.servicios.CuestionarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CuestionarioControlador {
	@Autowired
	private CuestionarioServicio cuestionarioServicio;
	
	@GetMapping("/cuestionarios")
	public String datos(){
		return "Hello "+cuestionarioServicio.findAll().toString();
	}
}
