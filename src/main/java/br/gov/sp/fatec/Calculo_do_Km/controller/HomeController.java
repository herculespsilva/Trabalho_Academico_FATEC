package br.gov.sp.fatec.Calculo_do_Km.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {

  @GetMapping
  public String welcome() {
      return "Hello World!";
  }

}