package br.gov.sp.fatec.Calculo_do_Km.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.math.BigDecimal;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.Calculo_do_Km.controller.View;

@Entity
@Table(name = "for_formulario")
public class Formulario {

/**Atributos da tabela Formulario */
@JsonView({View.UsuarioCompleto.class, View.FormularioCompleto.class})
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "for_id")
private Long id;

@JsonView({View.UsuarioResumo.class, View.FormularioResumo.class})
@Column(name = "for_modelo")
private String modelo;

@JsonView({View.UsuarioResumo.class, View.FormularioResumo.class})
@Column(name = "for_valor_automovel")
@Digits(integer = 6, fraction = 2)
private BigDecimal valor_automovel;

@JsonView({View.UsuarioResumo.class, View.FormularioResumo.class})
@Column(name = "for_depreciacao")
@Digits(integer = 6, fraction = 2)
private BigDecimal depreciacao;

/**Relacionamento N:1 de Formulario com Usuario */
@JsonView(View.FormularioResumo.class)
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "for_usr_id")
private Usuario usuario;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getModelo() {
    return modelo;
}

public void setModelo(String modelo) {
    this.modelo = modelo;
}

public BigDecimal getValor_automovel() {
    return valor_automovel;
}

public void setValor_automovel(BigDecimal valor_automovel) {
    this.valor_automovel = valor_automovel;
}

public BigDecimal getDepreciacao() {
    return depreciacao;
}

public void setDepreciacao(BigDecimal depreciacao) {
    this.depreciacao = depreciacao;
}

public Usuario getUsuario() {
    return usuario;
}

public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
}

/**Getters e Setters dos atributos */


}