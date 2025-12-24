package com.examen.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examen.crud.repository.RolRepository;
import com.examen.crud.model.Rol;
import java.util.Optional;

// Se inyecta el servicio para la entidad Rol
@Service
public class RolService {

  // Se crea la instancia del repositorio del rol
  private final RolRepository rolRepository;

  // Se crea el constructor para inyectar el repositorio
  public RolService(RolRepository rolRepository){
    this.rolRepository = rolRepository;
  }

  // Métodos para el CRUD de la entidad Rol
  // Método para obtener todos los roles
  public List<Rol> obtenerTodos(){
    return rolRepository.findAll();
  }

  // Método para obtener un rol por id
  public Optional<Rol> obtenerPorId(Long id){
    return rolRepository.findById(id);
  }

  // Método para obtener por nombre
  public List<Rol> obtenerPorNombre(String nombre){
    return rolRepository.findByNombre(nombre);
  }

  // Método para crear un rol
  public Rol crearRol(Rol rol){
    return rolRepository.save(rol);
  }

  // Método para actualizar un rol
  public Rol actualizarRol(Long id, Rol rol){
    rol.setId(id);
    return rolRepository.save(rol);
  }

  // Método para eliminar el rol
  public void eliminarRol(Long id){
    rolRepository.deleteById(id);
  }
  
}
