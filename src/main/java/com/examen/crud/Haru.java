package com.examen.crud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Haru {
  
  @GetMapping("/")
  public String getMethodName() {
      return "MENSAJE DE PRUEBA!!!";
  }
  
}
