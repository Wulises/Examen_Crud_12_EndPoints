package com.examen.crud.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

// Anotaciones para la creación de una tablas
@Entity
@Table(name = "TROLE")
public class Rol {
  
  //Generamos los atributos de nuestra tabla
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;

  //Ponemos la relación de muchos a muchos
  @ManyToMany(mappedBy = "roles")
  @JsonIgnore
  private Set<Usuario> usuarios = new HashSet<>();

  // Contructor vacío
  public Rol() {}

  //Constructor con nombre
  public Rol(String nombre){
    this.nombre = nombre;
  }

  // Getters y Setters
  public Long getId(){
    return id;
  }

  public String getNombre(){
    return nombre;
  }

  public Set<Usuario> getUsuarios(){
    return usuarios;
  } 

  public void setId(Long id){
    this.id = id;
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public void setUsuarios(Set<Usuario> usuarios){
    this.usuarios = usuarios;
  }


}
