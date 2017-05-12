package org.paquetes.repositorioDAO;

import org.paquetes.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

}
