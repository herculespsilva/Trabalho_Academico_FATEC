package br.gov.sp.fatec.Calculo_do_Km.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.Calculo_do_Km.security.JwtUtils;
import br.gov.sp.fatec.Calculo_do_Km.security.Login;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin
public class LoginController {

  @Autowired
  private AuthenticationManager authManager;

  @PostMapping()
  public Login autenticar(@RequestBody Login login) throws JsonProcessingException {
    Authentication auth = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()); /* Como Authentication é um interface, houve necessidade de instanciar o objeto pelo Spring Security */
    auth = authManager.authenticate(auth); /* Deopis de autenticato, as autorizacoes ja estara no contexto devido a uma busca no db */
    login.setPassword(null);
    login.setToken(JwtUtils.generateToken(auth));
    login.setAutorizacao(auth.getAuthorities().toString());
    return login;
  }
  
}
