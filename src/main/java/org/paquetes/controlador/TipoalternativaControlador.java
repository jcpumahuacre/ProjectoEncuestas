package org.paquetes.controlador;

import org.paquetes.servicios.TipoalternativaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TipoalternativaControlador {

	@Autowired
	private TipoalternativaServicio tipoalternativaServicio;
	
	@GetMapping("/tipoalternativas")
	public String datos(){
		return tipoalternativaServicio.findAll().toString();
	}
}
