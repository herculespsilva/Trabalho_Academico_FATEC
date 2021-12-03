package br.gov.sp.fatec.Calculo_do_Km.service;

import java.math.BigDecimal;
import java.util.List;

import br.gov.sp.fatec.Calculo_do_Km.entity.Formulario;


public interface FormularioService {

    public List<Formulario> buscarTodosFormularios();

    public Formulario buscarFormularioPorId(Long id);

    public List<Formulario> buscarFormularioPorModelo(String modelo);

    public List<Formulario> buscarFormularioPorUsuario(String usuario);

    public List<Formulario> buscaFormularioPorUsuarioNomeEValorSuperior(String nome, BigDecimal valor);

    public Formulario criaFormulario (String usuario, String modelo, BigDecimal valorCarro, BigDecimal depreciacao);

    public void deleteFormulario(Long id);

    public Formulario updateFormulario(Long id, String modelo, BigDecimal valorCarro);

}
