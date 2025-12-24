package com.examen.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.crud.model.Usuario;
import java.util.List;

// Se crea una inerfaz con extensión a al Jpa para poder utilizar la entidad Usuario
public interface UsuarioReposiroty extends JpaRepository<Usuario, Long>{
  
  // S ecrea un método para poder obtener el nombre del usuario
  List<Usuario> findByNombre(String nombre);

}
