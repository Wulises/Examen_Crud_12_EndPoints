package com.examen.crud.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.examen.crud.repository.RolRepository;
import com.examen.crud.repository.UsuarioReposiroty;
import com.examen.crud.model.Usuario;
import com.examen.crud.model.Rol;

// Inyección de dependencias
@Service
public class UsuarioService {
 
  // se crean las instancias de los repositorios 
  public final UsuarioReposiroty usuarioReposiroty;
  public final RolRepository rolRepository;

  // Se crea el constructor para inyectar los repositorios
  public UsuarioService(UsuarioReposiroty usuarioReposiroty, RolRepository rolRepository){
    this.usuarioReposiroty = usuarioReposiroty;
    this.rolRepository = rolRepository;
  }

  // Se crea el método para obtener todos los usuarios
  public List<Usuario> obtenerTodos(){
    return usuarioReposiroty.findAll();
  }

  // Se crea el método para obtener un usuario por su Id
  public Usuario obtenerPorId(Long id){
    return usuarioReposiroty.findById(id)
    .orElseThrow(() -> new RuntimeException("No se encontro el usuario con el id: " + id));
  }

  // Se crea el método para obtener por nobre
  public List<Usuario> obtenerPorNombre(String nombre){
    return usuarioReposiroty.findByNombre(nombre);
  }

  // Se crea el método para crear un Usuario nuevo
  public Usuario crearUsuario(Usuario usuario, List<Long> rolesIds) {

    // Se crea un set para almacenar y encontrar los roles
    Set<Rol> roles = new HashSet<>();

    // Iteramos todos los roles para encontrarlo por su Id
    for (Long rolId : rolesIds){
      Rol rol = rolRepository.findById(rolId)
      .orElseThrow(()-> new RuntimeException("No se encontro el rol con el id:" + rolId));
    // Agregamos el rol encontrado al Set
      roles.add(rol);
    }

    // Asignamos los roles al usuario
    usuario.setRoles(roles);
    return usuarioReposiroty.save(usuario);
  }

  // Se crea el método para actaulizar el usuario
  public Usuario actualizar(Long id, Usuario usuario, List<Long> rolesIds){

    // Obtenemos un usuario si existe
    Usuario existente = obtenerPorId(id);

    // Creamos un Set para alamcenar los roles
    Set<Rol> roles = new HashSet<>();

    // Iteramos los roles para encontrarlo por su id
    for (Long rolId : rolesIds){
      Rol rol = rolRepository.findById(rolId)
      .orElseThrow(() -> new RuntimeException("No se encontro el id :" + rolId));
    // Agregamos el rol encontrado al Set
      roles.add(rol);
    }

    // Actualizamos los campos del usuario
    existente.setNombre(usuario.getNombre());
    existente.setAPaterno(usuario.getAPaterno());
    existente.setAMaterno(usuario.getAMaterno());
    existente.setRoles(roles);

    // Guardamos el usaurio actualizado
    return usuarioReposiroty.save(existente);

  }

  // Se crea el método para eliminar al usuario
  public void eliminarUsuario(Long id){
    usuarioReposiroty.deleteById(id);
  }

}
