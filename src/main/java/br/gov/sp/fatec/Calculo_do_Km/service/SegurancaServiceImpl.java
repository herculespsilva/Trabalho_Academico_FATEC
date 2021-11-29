package br.gov.sp.fatec.Calculo_do_Km.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.Calculo_do_Km.entity.Autorizacao;
import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;
import br.gov.sp.fatec.Calculo_do_Km.exception.RegistroNaoEncontradoException;
import br.gov.sp.fatec.Calculo_do_Km.repository.AutorizacaoRepository;
import br.gov.sp.fatec.Calculo_do_Km.repository.UsuarioRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService{

    @Autowired
    public UsuarioRepository userRepo;

    @Autowired
    public AutorizacaoRepository autRepo;

    @Autowired
    private PasswordEncoder passEncoder;

    @Transactional
    public Usuario cadastroUsuario(String nome, String senha, String autorizacao) {

        Autorizacao aut = autRepo.findByNome(autorizacao);

        if(aut==null){
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autRepo.save(aut);
        }

        Usuario user = new Usuario();
        user.setNome(nome);
        user.setSenha(passEncoder.encode(senha));
        user.setAutorizacoes(new HashSet<Autorizacao>());
        user.getAutorizacoes().add(aut);
        userRepo.save(user);

        return user;
    }
    
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<Usuario> buscarTodosUsuarios() {
      return userRepo.findAll();
    }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public Usuario buscarUsuarioPorId(Long id) {
      Optional<Usuario> usuarioOp = userRepo.findById(id);
      if(usuarioOp.isPresent()) {
        return usuarioOp.get();
      }
      throw new RegistroNaoEncontradoException("Usuário não encontrado!");
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Usuario buscarUsuarioPorNome(String nome) {
      Usuario usuario = userRepo.findByNome(nome);
      if(usuario != null) {
        return usuario;
      }
      throw new RegistroNaoEncontradoException("Usuário não encontrado!");
    }

    @Override
    @Transactional
    @PreAuthorize("isAuthenticated()")
    public Usuario updateUsuario(Long id, String nome, String senha, String autorizacao) {

        Autorizacao aut = autRepo.findByNome(autorizacao);
        if (aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autRepo.save(aut);
        }

        return userRepo.findById(id)
           .map(user -> {
               user.setNome(nome);
               user.setSenha(senha);
               Usuario updated = userRepo.save(user);

               return updated;
        }).orElse(null);

    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public void deleteUsuario(Long id) {
      userRepo.deleteById(id);       
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Autorizacao buscarAutorizacaoPorNome(String nome) {
      Autorizacao autorizacao = autRepo.findByNome(nome);
      if(autorizacao != null) {
        return autorizacao;
      }
      throw new RegistroNaoEncontradoException("Autorização não encontrada!");
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario usuario = userRepo.findByNome(username);
    if (usuario == null) {
      throw new UsernameNotFoundException("Usuário " + username + " não encontrado!");
    }
    return User.builder().username(username).password(usuario.getSenha()) /* Necessario usar esse classe devido o metodo retornar um objeto do tipo UserDetails (interface)*/
        .authorities(usuario.getAutorizacoes().stream()                   /* Classe User do Spring Security, usa o padrão Builder para criar um usuario*/
            .map(Autorizacao::getNome).collect(Collectors.toList())
            .toArray(new String[usuario.getAutorizacoes().size()]))
        .build();
    }

}
