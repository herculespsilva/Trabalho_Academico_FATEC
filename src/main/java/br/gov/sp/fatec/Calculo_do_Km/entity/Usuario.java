package br.gov.sp.fatec.Calculo_do_Km.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.Calculo_do_Km.controller.View;

@Entity
@Table(name = "usr_usuario")
public class Usuario {

    /**Atributos da Tabela Usuario */
    @JsonView(View.UsuarioCompleto.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;

    @JsonView({View.UsuarioResumo.class, View.FormularioResumo.class, View.AutorizacaoResumo.class})
    @Column(name = "usr_nome")
    private String nome;

    @JsonView(View.UsuarioCompleto.class)
    @Column(name = "usr_senha")
    private String senha;

    /**Relacionamento N:N de Usuario com Autorizacao */

    @JsonView(View.UsuarioResumo.class)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "uau_usuario_autorizacao",
        joinColumns = { @JoinColumn(name = "usr_id")},
        inverseJoinColumns = { @JoinColumn(name = "aut_id") }
        )
    private Set<Autorizacao> autorizacoes;

    /**Relacionamento 1:N de Usuario com Formulario */

    @JsonView(View.UsuarioResumo.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Formulario> formularios;

    /**Getters e Setters dos atributos */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Autorizacao> getAutorizacoes() {
        return this.autorizacoes;
    }

    public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }

    public List<Formulario>  getFormularios() {
        return this.formularios;
    }

    public void setFormularios (List<Formulario> formularios) {
        this.formularios = formularios;
    }
}