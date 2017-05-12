package org.paquetes.servicios;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.paquetes.modelo.Categoria;
import org.paquetes.repositorioDAO.CategoriaRepositorio;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoriaServicio {

	private final CategoriaRepositorio categoriaRepositorio;

	public CategoriaServicio(CategoriaRepositorio categoriaRepositorio) {
		this.categoriaRepositorio = categoriaRepositorio;
	}
	
	public List<Categoria> findAll(){
		List<Categoria> categorias= new ArrayList<>();
		for(Categoria categoria : categoriaRepositorio.findAll()){
			categorias.add(categoria);
		}
		return categorias;
	}
	
	public Categoria findCategoria(int id){
		
		return categoriaRepositorio.findOne(id);
	}
	
	public void saveCategoria(Categoria categoria){
		categoriaRepositorio.save(categoria);
	}
	
	public void deleteCategoria(int id){
		categoriaRepositorio.delete(id);
		
	}
	
}
