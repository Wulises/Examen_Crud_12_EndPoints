package com.examen.crud.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

//Anotaciones para la creación de la tabla usuarios
@Entity
@Table(name = "TUSUARIO")
public class Usuario {

  //Generamos los atributos de la tablas
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private String aPaterno;
  private String aMaterno;

  //Gneramos la relación de muchos a muchos y el inner join de la tabla usuario_rol
  @ManyToMany
  @JoinTable(
    name = "USUARIO_ROL",
    joinColumns = @JoinColumn(name = "USUARIO_ID"),
    inverseJoinColumns = @JoinColumn(name = "ROL_ID")
  )

  private Set<Rol> roles = new HashSet<>();

  // Contructor Vacío
  public Usuario(){}

  // Constructor con datos
  public Usuario(String nombre, String aPaterno, String aMaterno){
    this.nombre = nombre;
    this.aPaterno = aPaterno;
    this.aMaterno = aMaterno;
  }

  // Getters y Setters
  public Long getId(){
    return id;
  }

  public String getNombre(){
    return nombre;
  }

  public String getAPaterno(){
    return aPaterno;
  }

  public String getAMaterno(){
    return aMaterno;
  }

  public Set<Rol> getRoles(){
    return roles;
  }

  public void setId(Long id){
    this.id = id;
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public void setAPaterno(String aPaterno){
    this.aPaterno = aPaterno;
  }

  public void setAMaterno(String aMaterno){
    this.aMaterno = aMaterno;
  }

  public void setRoles(Set<Rol> roles){
    this.roles = roles;
  }

}
