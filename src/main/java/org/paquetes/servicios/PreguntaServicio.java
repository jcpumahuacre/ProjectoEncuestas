package org.paquetes.servicios;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.paquetes.modelo.Pregunta;
import org.paquetes.repositorioDAO.PreguntaRepositorio;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PreguntaServicio {

	private final PreguntaRepositorio preguntaRepositorio;

	public PreguntaServicio(PreguntaRepositorio preguntaRepositorio) {
		this.preguntaRepositorio = preguntaRepositorio;
	}
	
	public List<Pregunta> findAll(){
		List<Pregunta> preguntas= new ArrayList<>();
		for(Pregunta pregunta : preguntaRepositorio.findAll()){
			preguntas.add(pregunta);
		}
		return preguntas;
	}
	
	public Pregunta findPregunta(int id){
		
		return preguntaRepositorio.findOne(id);
	}
	
	public void savePregunta(Pregunta categoria){
		preguntaRepositorio.save(categoria);
	}
	
	public void deletePregunta(int id){
		preguntaRepositorio.delete(id);
		
	}
}
