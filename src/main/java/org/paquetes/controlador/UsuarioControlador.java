package org.paquetes.controlador;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.paquetes.modelo.Usuario;
import org.paquetes.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio usuarioServicio;
	
	//@GetMapping("/usuarios")
	@RequestMapping("/usuarios")
	public String datos(){
		return "Hello "+usuarioServicio.findAll().toString();
	}

	//@GetMapping("/usuarios2")
	@RequestMapping("/usuarios2")
	public List<Usuario> datos2(){
		return usuarioServicio.findAll();
	}
	
	@RequestMapping("/greeting")
	public Object greeting(@RequestParam(value="name", defaultValue="world" ) String name){
		return String.format("Hola, %s", name);
	}
	
	
	
	private final AtomicLong counter = new AtomicLong();
	@RequestMapping("/saveUsuario")
	public String saveTask(@RequestParam String nombre, @RequestParam String paterno, @RequestParam String materno){
		Usuario usuario = new Usuario((int)counter.incrementAndGet(),paterno, materno, nombre, "correo@dominio.com");
		usuarioServicio.saveUsuario(usuario);
		return "Usuario Guardado !!!! ";
	}
	//prueba: ...?nombre=Victor&paterno=Romano&materno=Lara
}
