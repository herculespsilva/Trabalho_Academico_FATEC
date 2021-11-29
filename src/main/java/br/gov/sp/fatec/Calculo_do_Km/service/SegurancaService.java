package br.gov.sp.fatec.Calculo_do_Km.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.gov.sp.fatec.Calculo_do_Km.entity.Autorizacao;
import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;

public interface SegurancaService extends UserDetailsService { /* interface que o spring usa para buscar os dados do usuario durante o login */
    
    public Usuario cadastroUsuario(String nome, String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();

    public Usuario buscarUsuarioPorId(Long id);

    public Usuario buscarUsuarioPorNome(String nome);

    public void deleteUsuario(Long id);

    public Usuario updateUsuario(Long id, String nome, String senha, String autorizacao);

    public Autorizacao buscarAutorizacaoPorNome(String nome);

}
