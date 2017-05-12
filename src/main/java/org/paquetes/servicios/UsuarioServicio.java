package org.paquetes.servicios;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.paquetes.repositorioDAO.UsuarioRepositorio;
import org.paquetes.modelo.Usuario;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UsuarioServicio {

	private final UsuarioRepositorio usuarioRepositorio;

	public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}
	
	public List<Usuario> findAll(){
		List<Usuario> usuarios= new ArrayList<>();
		for(Usuario usuario : usuarioRepositorio.findAll()){
			usuarios.add(usuario);
		}
		return usuarios;
	}
	
	public Usuario findUsuario(int id){
		
		return usuarioRepositorio.findOne(id);
	}
	
	public void saveUsuario(Usuario  usuario){
		usuarioRepositorio.save(usuario);
	}
	
	public void deleteUsuario(int id){
		usuarioRepositorio.delete(id);
		
	}
	
	
}
