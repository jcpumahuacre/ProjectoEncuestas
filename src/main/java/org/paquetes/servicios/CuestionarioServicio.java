package org.paquetes.servicios;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.paquetes.modelo.Cuestionario;
import org.paquetes.repositorioDAO.CuestionarioRepositorio;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CuestionarioServicio {


	private final CuestionarioRepositorio CuestionarioRepositorio;

	public CuestionarioServicio(CuestionarioRepositorio categoriaRepositorio) {
		this.CuestionarioRepositorio = categoriaRepositorio;
	}
	
	public List<Cuestionario> findAll(){
		List<Cuestionario> cuestionarios= new ArrayList<>();
		for(Cuestionario cuestionario : CuestionarioRepositorio.findAll()){
			cuestionarios.add(cuestionario);
		}
		return cuestionarios;
	}
	
	public Cuestionario findCuestionario(int id){
		
		return CuestionarioRepositorio.findOne(id);
	}
	
	public void saveCuestionario(Cuestionario categoria){
		CuestionarioRepositorio.save(categoria);
	}
	
	public void deleteCuestionario(int id){
		CuestionarioRepositorio.delete(id);
		
	}
	
}
