package org.paquetes.servicios;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.paquetes.modelo.Tipoalternativa;
import org.paquetes.repositorioDAO.TipoalternativaRepositorio;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TipoalternativaServicio {

	private final TipoalternativaRepositorio tipoalternativaRepositorio;

	public TipoalternativaServicio(TipoalternativaRepositorio tipoalternativaRepositorio) {
		this.tipoalternativaRepositorio = tipoalternativaRepositorio;
	}
	
	public List<Tipoalternativa> findAll(){
		List<Tipoalternativa> tipoalternativas= new ArrayList<>();
		for(Tipoalternativa tipoalternativa : tipoalternativaRepositorio.findAll()){
			tipoalternativas.add(tipoalternativa);
		}
		return tipoalternativas;
	}
	
	public Tipoalternativa findTipoalternativa(int id){
		
		return tipoalternativaRepositorio.findOne(id);
	}
	
	public void saveTipoalternativa(Tipoalternativa categoria){
		tipoalternativaRepositorio.save(categoria);
	}
	
	public void deleteTipoalternativa(int id){
		tipoalternativaRepositorio.delete(id);
		
	}
}
