package org.paquetes.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.paquetes.modelo.Alternativa;
import org.paquetes.repositorioDAO.AlternativaRepositorio;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AlternativaServicio {

	private final AlternativaRepositorio alternativaRepositorio;

	public AlternativaServicio(AlternativaRepositorio alternativaRepositorio) {
		this.alternativaRepositorio = alternativaRepositorio;
	}
	
	public List<Alternativa> findAll(){
		List<Alternativa> alternativas= new ArrayList<>();
		for(Alternativa alternativa : alternativaRepositorio.findAll()){
			alternativas.add(alternativa);
		}
		return alternativas;
	}
	
	public Alternativa findAlternativa(int id){
		
		return alternativaRepositorio.findOne(id);
	}
	
	public void saveAlternativa(Alternativa categoria){
		alternativaRepositorio.save(categoria);
	}
	
	public void deleteAlternativa(int id){
		alternativaRepositorio.delete(id);
		
	}
}
