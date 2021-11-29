package br.gov.sp.fatec.Calculo_do_Km.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.Calculo_do_Km.controller.View;

@Entity
@Table(name = "aut_autorizacao")
public class Autorizacao {

    /*Atributos da tabela Autorizacao*/
    @JsonView(View.UsuarioCompleto.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_id")
    private Long id;

    @JsonView({View.UsuarioResumo.class, View.AutorizacaoResumo.class})
    @Column(name = "aut_nome")
    private String nome;


    /**Habilito se eu quiser retornar uma lista de Usuarios por Autorizações*/
    @JsonView(View.AutorizacaoResumo.class)
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "autorizacoes")
    private Set<Usuario> usuarios;

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

    /**Habilito se eu quiser Getter e Setter para retornar uma Lista de Usuarios por Autorizacoes */

    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}