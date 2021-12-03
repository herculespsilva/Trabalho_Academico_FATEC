package br.gov.sp.fatec.Calculo_do_Km.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import br.gov.sp.fatec.Calculo_do_Km.entity.Formulario;
import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;
import br.gov.sp.fatec.Calculo_do_Km.exception.RegistroNaoEncontradoException;
import br.gov.sp.fatec.Calculo_do_Km.repository.FormularioRepository;
import br.gov.sp.fatec.Calculo_do_Km.repository.UsuarioRepository;

@Service("FormularioService")
public class FormularioServiceImpl implements FormularioService {

    @Autowired
    UsuarioRepository userRepo;

    @Autowired
    FormularioRepository formRepo;
    
    @Override
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public Formulario buscarFormularioPorId(Long id){
        if(id != null && id > 0) {
            Formulario formulario = formRepo.querybuscaFormularioPorId(id);
            return formulario;
        }
        return null;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<Formulario> buscarTodosFormularios() {
      return formRepo.findAll();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public List<Formulario> buscarFormularioPorModelo (String modelo) {
        if (modelo != "") {
            List<Formulario> formulario = formRepo.querybuscaFormularioPorModelo(modelo);
            
            if(!(formulario.isEmpty())) { // negação de vazio 
                return formulario;
            }
        }
        return null;
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public List<Formulario> buscarFormularioPorUsuario(String usuario) {
        if (usuario != "") {
            List<Formulario> formulario = formRepo.querybuscaTodosFormularioPorUsuarioNome(usuario);
            
            if(!(formulario.isEmpty())) { // negação de vazio 
                return formulario;
            }
        }
        return null;
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public List<Formulario> buscaFormularioPorUsuarioNomeEValorSuperior(String nome, BigDecimal valor) {
        Usuario usuario = userRepo.findByNome(nome);

        if(usuario != null) {
            if (valor.compareTo(new BigDecimal("0")) == 1 || valor.compareTo(new BigDecimal("0")) == 0) {
                List<Formulario> formulario = formRepo.queryBuscaFormularioPorUsuarioNomeEValorSuperior(nome, valor);
                return formulario;
            }
        }
        return null;
    }

    @Override
    @Transactional
    public Formulario criaFormulario (String usuario, String modelo, BigDecimal valorCarro, BigDecimal depreciacao) {
        Usuario user = userRepo.findByNome(usuario);

        if(user == null) {
            throw new RegistroNaoEncontradoException("Usuário não encontrado!");
        }

        Formulario formulario = new Formulario();
        formulario.setUsuario(user);
		formulario.setModelo(modelo);
		formulario.setValor_automovel(valorCarro);
        formulario.setDepreciacao(depreciacao);
		formRepo.save(formulario);

        return formulario;
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public void deleteFormulario(Long id){
        Formulario formulario = formRepo.querybuscaFormularioPorId(id);
            if(id != null && id > 0) {
                formRepo.deleteById(formulario.getId());
            }
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Formulario updateFormulario (Long id, String modelo, BigDecimal valorCarro) {
        Formulario formulario = formRepo.querybuscaFormularioPorId(id);

            if(formulario != null) { 
                formulario.setId(id);
                formulario.setModelo(modelo);
                formulario.setValor_automovel(valorCarro);
                formRepo.save(formulario);
                return formulario;
            }
        return null;
    }
}