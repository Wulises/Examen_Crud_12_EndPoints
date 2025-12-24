package com.examen.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.crud.service.RolService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.examen.crud.model.Rol;
import java.util.List;

import javax.management.RuntimeErrorException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



// Inyección de dependencias
@RestController
// Mapeo de la ruta para el controlador
@RequestMapping("/roles")
public class RolController {
  
  // Instancia del servico del rol
  private final RolService rolService;

  // Contstructor para inyectar lel serivicio
  public RolController(RolService rolService){
    this.rolService = rolService;
  }

  // Get /roles
  // Enpoint para Obtener todos los roles
  @GetMapping
  public List<Rol> obtenerRoler(){
    return rolService.obtenerTodos();
  }

  // Get /roles/{id}
  // EndPoint para obtener por su id
  @GetMapping("/{id}")
  public Rol obtenerProId(@PathVariable Long id){
    return rolService.obtenerPorId(id)
    .orElseThrow(() -> new RuntimeException("No se pudo encontrar el rol con el id: " + id));
  }

  // Get /roles/nombre/{nombre}
  // EndPoint para obtener por nombre
  @GetMapping("/nombre/{nombre}")
  public List<Rol> obtenerPorNombre(@PathVariable String nombre){
    return rolService.obtenerPorNombre(nombre);
  }

  // Post /roles
  // EndPoint para crear un rol
  @PostMapping("/{id}")
  public Rol crearRol(@RequestBody Rol rol){
    return rolService.crearRol(rol);
  }

  // Put /roles/{id}
  // EndPoint para actualizar el rol
  @PutMapping("/{id}")
  public Rol actualizarRol(@PathVariable Long id, @RequestBody Rol rol){
    return rolService.actualizarRol(id, rol);
  }
  
  // Delete /roles/{id}
  // EndPoint para eliminar el rol
  @DeleteMapping("/{id}")
  public void eliminarRol(@PathVariable Long id){
    rolService.eliminarRol(id);
  }

}
