package com.examen.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examen.crud.model.Rol;
import java.util.List;

//Creamos la interfaz que extenderá de JpaRepostory para manejar la entidad Rol
public interface RolRepository extends JpaRepository<Rol, Long>{

  // Creamos el método para buscar roles por su nombre
  List<Rol> findByNombre(String nombre);

}