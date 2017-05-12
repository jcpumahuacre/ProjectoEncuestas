package org.paquetes.controlador;

import org.paquetes.servicios.PreguntaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreguntaControlador {

	@Autowired
	private PreguntaServicio preguntaServicio;
	
	@GetMapping("/preguntas")
	public String datos(){
		return preguntaServicio.findAll().toString();
	}
}
