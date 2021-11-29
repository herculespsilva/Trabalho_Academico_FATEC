package br.gov.sp.fatec.Calculo_do_Km.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.sp.fatec.Calculo_do_Km.entity.Autorizacao;
import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;
import br.gov.sp.fatec.Calculo_do_Km.service.SegurancaService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {

  @Autowired
  private SegurancaService segurancaService;

  @JsonView(View.UsuarioResumo.class)
  @GetMapping()
  public List<Usuario> buscarTodos() {
    return segurancaService.buscarTodosUsuarios();
  }

  @JsonView(View.UsuarioCompleto.class)
  @GetMapping(value = "/{id}")
  public Usuario buscarPorId(@PathVariable("id") Long id) {
    return segurancaService.buscarUsuarioPorId(id);
  }

  @JsonView(View.UsuarioResumo.class)
  @GetMapping(value = "/nome")
  public Usuario buscarPorNome(@RequestParam(value="nome") String nome) {
    return segurancaService.buscarUsuarioPorNome(nome);
  }
  
  @JsonView(View.UsuarioResumo.class)
  @PostMapping
  public ResponseEntity<Usuario> cadastraNovoUsuario (@RequestBody Usuario usuario,
         UriComponentsBuilder uriComponentsBuilder) {
      usuario = segurancaService.cadastroUsuario(usuario.getNome(), usuario.getSenha(), "ROLE_USUARIO");
      HttpHeaders responseHeaders = new HttpHeaders();
      responseHeaders.setLocation(
        uriComponentsBuilder.path(
            "/usuario/" + usuario.getId()).build().toUri());
    return new ResponseEntity<Usuario>(usuario, responseHeaders, HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        try{
            segurancaService.deleteUsuario(id);
            return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
  }

  @PutMapping(value="/altera/{id}")
  public Usuario update(@PathVariable("id") long id,@RequestBody Usuario user) {
      try{
          return segurancaService.updateUsuario(id, user.getNome(), user.getSenha(), "ROLE_USUARIO");
      }catch (Exception e){
          return null;
      }
  }

  @JsonView(View.AutorizacaoResumo.class)
  @GetMapping(value = "/autorizacao/{autorizacao}")
  public Autorizacao buscarAutorizacaoPorNome(@PathVariable("autorizacao") String nome) {
    return segurancaService.buscarAutorizacaoPorNome(nome);
  }
}