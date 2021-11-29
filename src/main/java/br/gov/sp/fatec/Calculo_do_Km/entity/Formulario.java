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

@JsonView(View.FormularioResumo.class)
@Column(name = "for_depreciacao")
@Digits(integer = 6, fraction = 2)
private BigDecimal depreciacao;

@Column(name = "for_km_mes ")
@Digits(integer = 6, fraction = 2)
private BigDecimal km_mes;

@Column(name = "for_km_anual ")
@Digits(integer = 6, fraction = 2)
private BigDecimal km_anual;

@Column(name = "for_valor_depreciação")
@Digits(integer = 6, fraction = 2)
private BigDecimal valor_depreciação;

@Column(name = "for_ipva")
@Digits(integer = 6, fraction = 2)
private BigDecimal ipva;

@Column(name = "for_preco_seguro_anual")
@Digits(integer = 6, fraction = 2)
private BigDecimal preco_seguro_anual;

@Column(name = "for_custo_seguro_licenciamento_km ")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_seguro_licenciamento_km;

@Column(name = "for_custo_pneu ")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_pneu;

@Column(name = "for_vida_util_pneu ")
@Digits(integer = 6, fraction = 2)
private BigDecimal vida_util_pneu;

@Column(name = "for_custo_pneu_km ")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_pneu_km;

@Column(name = "for_custo_troca_oleo ")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_troca_oleo;

@Column(name = "for_frequencia_km_troca ")
@Digits(integer = 6, fraction = 2)
private BigDecimal frequencia_km_troca;

@Column(name = "dor_custo_oleo_km ")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_oleo_km;

@Column(name = "for_custo_manutenção_anual ")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_manutenção_anual;

@Column(name = "for_custo_manutencao_km")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_manutencao_km;

@Column(name = "for_aluguel_mensal")
@Digits(integer = 6, fraction = 2)
private BigDecimal aluguel_mensal;

@Column(name = "for_custo_aluguel_km")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_aluguel_km;

@Column(name = "for_preco_gasolina")
@Digits(integer = 6, fraction = 2)
private BigDecimal preco_gasolina;

@Column(name = "for_consumo_gasolina")
@Digits(integer = 6, fraction = 2)
private BigDecimal consumo_gasolina;

@Column(name = "for_custo_gasolina_km")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_gasolina_km;

@Column(name = "for_preco_etanol")
@Digits(integer = 6, fraction = 2)
private BigDecimal preco_etanol;

@Column(name = "for_consumo_etanol")
@Digits(integer = 6, fraction = 2)
private BigDecimal consumo_etano;

@Column(name = "for_custo_etanol_km")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_etanol_km;

@Column(name = "for_preco_gnv")
@Digits(integer = 6, fraction = 2)
private BigDecimal preco_gnv;

@Column(name = "for_consumo_gnv")
@Digits(integer = 6, fraction = 2)
private BigDecimal consumo_gnv;

@Column(name = "for_custo_gnv_km")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_gnv_km;

@Column(name = "for_salario_mes")
@Digits(integer = 6, fraction = 2)
private BigDecimal salario_mes;

@Column(name = "for_custo_salario_km")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_salario_km;

@Column(name = "for_custo_total_gasolina_km")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_total_gasolina_km;

@Column(name = "for_custo_total_gasolina_mensal_km")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_total_gasolina_mensal_km;

@Column(name = "for_custo_total_etanol_km")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_total_etanol_km;

@Column(name = "for_custo_total_etanol_mensal_km")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_total_etanol_mensal_km;

@Column(name = "for_custo_total_gnv_km")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_total_gnv_km;

@Column(name = "for_custo_total_gnv_mensal_km")
@Digits(integer = 6, fraction = 2)
private BigDecimal custo_total_gnv_mensal_km;

@Column(name = "for_ganho_medio_corrida_km")
@Digits(integer = 6, fraction = 2)
private BigDecimal ganho_medio_corrida_km;

@Column(name = "for_ganho_total")
@Digits(integer = 6, fraction = 2)
private BigDecimal ganho_total;

@Column(name = "for_lucro_final_gasolina")
@Digits(integer = 6, fraction = 2)
private BigDecimal lucro_final_gasolina;

@Column(name = "for_lucro_final_etanol")
@Digits(integer = 6, fraction = 2)
private BigDecimal lucro_final_etanol;

@Column(name = "for_lucro_final_gnv")
@Digits(integer = 6, fraction = 2)
private BigDecimal lucro_final_gnv;

/**Relacionamento N:1 de Formulario com Usuario */
@JsonView(View.FormularioResumo.class)
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "for_usr_id")
private Usuario usuario;

/**Getters e Setters dos atributos */

public Long getId() {
    return this.id;
}

public void setId(Long id) {
    this.id = id;
}

public String getModelo() {
    return this.modelo;
}

public void setModelo(String modelo) {
    this.modelo = modelo;
}

public BigDecimal getValorAutomovel() {
    return this.valor_automovel;
}

public void setValorAutomovel(BigDecimal valor_automovel) {
    this.valor_automovel = valor_automovel;
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

public BigDecimal getKm_mes() {
    return km_mes;
}

public void setKm_mes(BigDecimal km_mes) {
    this.km_mes = km_mes;
}

public BigDecimal getKm_anual() {
    return km_anual;
}

public void setKm_anual(BigDecimal km_anual) {
    this.km_anual = km_anual;
}

public BigDecimal getValor_depreciação() {
    return valor_depreciação;
}

public void setValor_depreciação(BigDecimal valor_depreciação) {
    this.valor_depreciação = valor_depreciação;
}

public BigDecimal getIpva() {
    return ipva;
}

public void setIpva(BigDecimal ipva) {
    this.ipva = ipva;
}

public BigDecimal getPreco_seguro_anual() {
    return preco_seguro_anual;
}

public void setPreco_seguro_anual(BigDecimal preco_seguro_anual) {
    this.preco_seguro_anual = preco_seguro_anual;
}

public BigDecimal getCusto_seguro_licenciamento_km() {
    return custo_seguro_licenciamento_km;
}

public void setCusto_seguro_licenciamento_km(BigDecimal custo_seguro_licenciamento_km) {
    this.custo_seguro_licenciamento_km = custo_seguro_licenciamento_km;
}

public BigDecimal getCusto_pneu() {
    return custo_pneu;
}

public void setCusto_pneu(BigDecimal custo_pneu) {
    this.custo_pneu = custo_pneu;
}

public BigDecimal getVida_util_pneu() {
    return vida_util_pneu;
}

public void setVida_util_pneu(BigDecimal vida_util_pneu) {
    this.vida_util_pneu = vida_util_pneu;
}

public BigDecimal getCusto_pneu_km() {
    return custo_pneu_km;
}

public void setCusto_pneu_km(BigDecimal custo_pneu_km) {
    this.custo_pneu_km = custo_pneu_km;
}

public BigDecimal getCusto_troca_oleo() {
    return custo_troca_oleo;
}

public void setCusto_troca_oleo(BigDecimal custo_troca_oleo) {
    this.custo_troca_oleo = custo_troca_oleo;
}

public BigDecimal getFrequencia_km_troca() {
    return frequencia_km_troca;
}

public void setFrequencia_km_troca(BigDecimal frequencia_km_troca) {
    this.frequencia_km_troca = frequencia_km_troca;
}

public BigDecimal getCusto_oleo_km() {
    return custo_oleo_km;
}

public void setCusto_oleo_km(BigDecimal custo_oleo_km) {
    this.custo_oleo_km = custo_oleo_km;
}
public BigDecimal getCusto_manutenção_anual() {
    return custo_manutenção_anual;
}

public void setCusto_manutenção_anual(BigDecimal custo_manutenção_anual) {
    this.custo_manutenção_anual = custo_manutenção_anual;
}

public BigDecimal getCusto_manutencao_km() {
    return custo_manutencao_km;
}

public void setCusto_manutencao_km(BigDecimal custo_manutencao_km) {
    this.custo_manutencao_km = custo_manutencao_km;
}
public BigDecimal getAluguel_mensal() {
    return aluguel_mensal;
}

public void setAluguel_mensal(BigDecimal aluguel_mensal) {
    this.aluguel_mensal = aluguel_mensal;
}

public BigDecimal getCusto_aluguel_km() {
    return custo_aluguel_km;
}

public void setCusto_aluguel_km(BigDecimal custo_aluguel_km) {
    this.custo_aluguel_km = custo_aluguel_km;
}

public BigDecimal getPreco_gasolina() {
    return preco_gasolina;
}

public void setPreco_gasolina(BigDecimal preco_gasolina) {
    this.preco_gasolina = preco_gasolina;
}

public BigDecimal getConsumo_gasolina() {
    return consumo_gasolina;
}

public void setConsumo_gasolina(BigDecimal consumo_gasolina) {
    this.consumo_gasolina = consumo_gasolina;
}

public BigDecimal getCusto_gasolina_km() {
    return custo_gasolina_km;
}

public void setCusto_gasolina_km(BigDecimal custo_gasolina_km) {
    this.custo_gasolina_km = custo_gasolina_km;
}

public BigDecimal getPreco_etanol() {
    return preco_etanol;
}

public void setPreco_etanol(BigDecimal preco_etanol) {
    this.preco_etanol = preco_etanol;
}

public BigDecimal getConsumo_etano() {
    return consumo_etano;
}

public void setConsumo_etano(BigDecimal consumo_etano) {
    this.consumo_etano = consumo_etano;
}

public BigDecimal getCusto_etanol_km() {
    return custo_etanol_km;
}

public void setCusto_etanol_km(BigDecimal custo_etanol_km) {
    this.custo_etanol_km = custo_etanol_km;
}

public BigDecimal getPreco_gnv() {
    return preco_gnv;
}

public void setPreco_gnv(BigDecimal preco_gnv) {
    this.preco_gnv = preco_gnv;
}

public BigDecimal getConsumo_gnv() {
    return consumo_gnv;
}

public void setConsumo_gnv(BigDecimal consumo_gnv) {
    this.consumo_gnv = consumo_gnv;
}

public BigDecimal getCusto_gnv_km() {
    return custo_gnv_km;
}

public void setCusto_gnv_km(BigDecimal custo_gnv_km) {
    this.custo_gnv_km = custo_gnv_km;
}

public BigDecimal getSalario_me() {
    return salario_mes;
}

public void setSalario_me(BigDecimal salario_me) {
    this.salario_mes = salario_me;
}

public BigDecimal getCusto_salario_km() {
    return custo_salario_km;
}

public void setCusto_salario_km(BigDecimal custo_salario_km) {
    this.custo_salario_km = custo_salario_km;
}

public BigDecimal getCusto_total_gasolina_km() {
    return custo_total_gasolina_km;
}

public void setCusto_total_gasolina_km(BigDecimal custo_total_gasolina_km) {
    this.custo_total_gasolina_km = custo_total_gasolina_km;
}

public BigDecimal getCusto_total_gasolina_mensal_km() {
    return custo_total_gasolina_mensal_km;
}

public void setCusto_total_gasolina_mensal_km(BigDecimal custo_total_gasolina_mensal_km) {
    this.custo_total_gasolina_mensal_km = custo_total_gasolina_mensal_km;
}

public BigDecimal getCusto_total_etanol_km() {
    return custo_total_etanol_km;
}

public void setCusto_total_etanol_km(BigDecimal custo_total_etanol_km) {
    this.custo_total_etanol_km = custo_total_etanol_km;
}

public BigDecimal getCusto_total_etanol_mensal_km() {
    return custo_total_etanol_mensal_km;
}

public void setCusto_total_etanol_mensal_km(BigDecimal custo_total_etanol_mensal_km) {
    this.custo_total_etanol_mensal_km = custo_total_etanol_mensal_km;
}

public BigDecimal getCusto_total_gnv_km() {
    return custo_total_gnv_km;
}

public void setCusto_total_gnv_km(BigDecimal custo_total_gnv_km) {
    this.custo_total_gnv_km = custo_total_gnv_km;
}

public BigDecimal getCusto_total_gnv_mensal_km() {
    return custo_total_gnv_mensal_km;
}

public void setCusto_total_gnv_mensal_km(BigDecimal custo_total_gnv_mensal_km) {
    this.custo_total_gnv_mensal_km = custo_total_gnv_mensal_km;
}

public BigDecimal getGanho_medio_corrida_km() {
    return ganho_medio_corrida_km;
}

public void setGanho_medio_corrida_km(BigDecimal ganho_medio_corrida_km) {
    this.ganho_medio_corrida_km = ganho_medio_corrida_km;
}

public BigDecimal getGanho_total() {
    return ganho_total;
}

public void setGanho_total(BigDecimal ganho_total) {
    this.ganho_total = ganho_total;
}

public BigDecimal getLucro_final_gasolina() {
    return lucro_final_gasolina;
}

public void setLucro_final_gasolina(BigDecimal lucro_final_gasolina) {
    this.lucro_final_gasolina = lucro_final_gasolina;
}

public BigDecimal getLucro_final_etanol() {
    return lucro_final_etanol;
}

public void setLucro_final_etanol(BigDecimal lucro_final_etanol) {
    this.lucro_final_etanol = lucro_final_etanol;
}

public BigDecimal getLucro_final_gnv() {
    return lucro_final_gnv;
}

public void setLucro_final_gnv(BigDecimal lucro_final_gnv) {
    this.lucro_final_gnv = lucro_final_gnv;
}

public Usuario getUsuario() {
    return usuario;
}

public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
}

}