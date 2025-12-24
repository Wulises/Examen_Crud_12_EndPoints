package com.examen.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.crud.model.Usuario;
import com.examen.crud.service.UsuarioService;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




// Inyección de depnendencias

@RestController
// Mapeo de la ruta para el controlador
@RequestMapping("/usuarios")
public class UsuarioController {
  
  // Instancia del servicio del usuario
  private final UsuarioService usuarioService;

  // Constructor para la inyección del servicio
  public UsuarioController(UsuarioService usuarioService){
    this.usuarioService = usuarioService;
  }

  // Get /usuarios
  // Enpoint para obtener todos los usuarios
  @GetMapping
  public List<Usuario> obtenerUsuarios(){
    return usuarioService.obtenerTodos();
  }

  // Get /usuarios/{id}
  // EndPoint para obtener el usuario por id
  @GetMapping("/{id}")
  public Usuario obtenerPorId(@PathVariable Long id){
    return usuarioService.obtenerPorId(id);
  }

  // Get /usarios/nombre/{nombre}
  // EndPoint para obtener por nombre
  @GetMapping("/nombre/{nombre}")
  public List<Usuario> obtenerPorNombre(@PathVariable String nombre){
    return usuarioService.obtenerPorNombre(nombre);
  }

  // Post /usuarios
  // EndPoint para crear un usuario
  @PostMapping
  public Usuario crearUsuario(@RequestBody Map<String, Object> request) {

    // Creamos un objeto usuario de la clase Usuario
    Usuario usuario = new Usuario(
      (String) request.get("nombre"),
      (String) request.get("aPaterno"),
      (String) request.get("aMaterno")
    );

    // Creamos una lista de enteros para obtener los ids de los rols
    List<Integer> rolesIdsInt = (List<Integer>) request.get("roles");
    // Creamos una lista de Long para converti los ids de enteros a Long
    List<Long> rolesIds = rolesIdsInt.stream()
    .map(Long::valueOf)
    // Por último convertimos el stream a lista
    .toList();

    // Le pasamos los valores al service para crear el usuario
    return usuarioService.crearUsuario(usuario, rolesIds);

  }  

  // PUT / usuarios/{id}
  // EnndPoint para actualizar el usaurio
  @PutMapping("/{id}")
  public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Map<String, Object> request){

    // Creamos un objeto usuario de la clase Usuario
    Usuario usuario = new Usuario(
      (String) request.get("nombre"),
      (String) request.get("aPaterno"),
      (String) request.get("aMaterno")
    );

    // Creamos una lista de enteros para obtener los ids de los rols
    List<Integer> rolesIdsInt = (List<Integer>) request.get("roles");
    // Creamos una lista de Long para converti los ids de enteros a Long
    List<Long> rolesIds = rolesIdsInt.stream()
    .map(Long::valueOf)
    // Por último convertimos el stream a lista
    .toList();

    return usuarioService.actualizar(id, usuario, rolesIds);
  }

  // Delete /usuarios/{id}
  // EndPoint para eliminar el usuario
  @DeleteMapping("/{id}")
  public void eliminarUsuario(@PathVariable Long id){
    usuarioService.eliminarUsuario(id);
  }

}
