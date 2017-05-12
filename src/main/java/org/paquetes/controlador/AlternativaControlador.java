package org.paquetes.controlador;

import org.paquetes.servicios.AlternativaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlternativaControlador {
	@Autowired
	private AlternativaServicio alternativaServicio;
	
	@GetMapping("/alternativas")
	public String datos(){
		return alternativaServicio.findAll().toString();
	}
}
