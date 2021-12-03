package br.gov.sp.fatec.Calculo_do_Km.controller;

import java.math.BigDecimal;
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

import br.gov.sp.fatec.Calculo_do_Km.entity.Formulario;
import br.gov.sp.fatec.Calculo_do_Km.service.FormularioService;

@RestController
@RequestMapping(value = "/formulario")
@CrossOrigin
public class FormularioController {

    @Autowired
    FormularioService formService;

    @JsonView(View.FormularioResumo.class)
    @GetMapping()
    public List<Formulario> buscarTodos() {
        return formService.buscarTodosFormularios();
    }

    @JsonView(View.FormularioCompleto.class)
    @GetMapping(value = "/{id}")
    public Formulario buscarPorId(@PathVariable("id") Long id) {
        return formService.buscarFormularioPorId(id);
    }

    @JsonView(View.FormularioResumo.class)
    @GetMapping(value = "/modelo")
    public List<Formulario> buscarPorNome(@RequestParam(value="modelo") String modelo) {
        return formService.buscarFormularioPorModelo(modelo);
    }

    @JsonView(View.FormularioResumo.class) //testar consulta com dois parametrod
    @GetMapping(value = "/usuario-modelo")
    public List<Formulario> buscaPorUsuarioNomeEValorSuperior(@RequestParam(value="nome") String nome, @RequestParam(value="valor") BigDecimal valor) {
        return formService.buscaFormularioPorUsuarioNomeEValorSuperior(nome, valor);
    }

    @JsonView(View.FormularioResumo.class) //testar consulta com dois parametrod
    @GetMapping(value = "/usuario")
    public List<Formulario> buscarFormularioPorUsuario(@RequestParam(value="usuario") String usuario) {
        return formService.buscarFormularioPorUsuario(usuario);
    }

    @JsonView(View.FormularioResumo.class)
    @PostMapping
    public ResponseEntity<Formulario> cadastraNovoFormulario (@RequestBody Formulario formulario,
           UriComponentsBuilder uriComponentsBuilder) {
        formulario = formService.criaFormulario(formulario.getUsuario().getNome(), formulario.getModelo(), 
                                formulario.getValor_automovel(), formulario.getDepreciacao()); // validar se no formulario precisa informar a senha
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(
            uriComponentsBuilder.path(
                "/formulario/" + formulario.getId()).build().toUri());
        return new ResponseEntity<Formulario>(formulario, responseHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        try{
            formService.deleteFormulario(id);
            return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @PutMapping(value="/altera/{id}")
    public Formulario update(@PathVariable("id") long id,@RequestBody Formulario formulario) {
        try{
            return formService.updateFormulario(id, formulario.getModelo(), formulario.getValor_automovel());

        }catch (Exception e){
            return null;
        }
    }
}