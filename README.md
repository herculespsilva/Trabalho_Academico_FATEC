[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/mineda/spring-boot-app)


Para rodar utilize: mvn spring-boot:run


# Cálculo do Km.
## Trabalho acadêmico (FATEC) realizado na disciplina de Laboratório de Desenvolvimento de Banco de Dados 5.
### Autores:
### 👨‍💻 [Victor Cardial de Menezes Pereira](https://www.linkedin.com/in/victor-cardial-de-menezes-pereira-67491018a/)
### 👨‍💻 [Hércules Pereira da Silva](https://www.linkedin.com/in/hercules-pereira/)

#### (Lista de Rascunho) Informações que iremos utilizar...


### - Custos:

Modelo/Marca

Valor do automóvel (FIP)  

Depreciação    

km mês    

km anual    
#### Valor Depreciação = depreciação anual/ km anual


#### IPVA + licenciamento anual = valor/ km anual
#### Preço do Seguro anual = valor/ km anual


Custo dos Pneus

Vida Útil Pneus (km)
#### Valor gasto dos Pneus por km= custo dos pneus/ vida útil pneus


Custo troca de óleo

Frequência em km da troca.
#### Valor gasto com óleo por km= custo da troca/ frequência em km da troca


Custo com manutenção (anual)
#### Gasto com manutenção por km= Custo com manutenção/ km anual


Preço da gasolina

Consumo da gasolina por km
#### Custo da gasolina por km = preço da gasolina/ Consumo da gasolina por km


Preço do etanol

Consumo do etanol por km
#### Custo do etanol por km = preço do etanol / Consumo do etanol por km


Preço do GNV

Consumo do GNV por km
#### Custo do GNV por km = preço do GNV / Consumo do GNV por km


Salário (mês)
#### Renda por km= salario/ km mes


#### Custo Total km gasolina = Valor Depreciação + (IPVA + licenciamento anual) + Preço do Seguro anual + Valor gasto dos Pneus por km + Valor gasto com óleo por km + Gasto com manutenção por km + Custo da gasolina por km + Renda por km.

#### Custo Total Mensal Gasolina = Custo Total km gasolina * km mês


#### Custo Total km Etanol = Valor Depreciação + (IPVA + licenciamento anual) + Preço do Seguro anual + Valor gasto dos Pneus por km + Valor gasto com óleo por km + Gasto com manutenção por km + Custo do etanol por km + Renda por km.

#### Custo Total Mensal Etanol = Custo Total km Etanol * km mês


#### Custo Total km GNV = Valor Depreciação + (IPVA + licenciamento anual) + Preço do Seguro anual + Valor gasto dos Pneus por km + Valor gasto com óleo por km + Gasto com manutenção por km + Custo do GNV por km + Renda por km.

#### Custo Total Mensal GNV = Custo Total km GNV * km mês


### - Projeção de Ganhos:


Ganho médio na corrida por km
#### Ganhos Mensais totais = ganho médio na corrida por km * km mês


### - Lucro Final


#### Lucro Gasolina= Ganhos Mensais totais - Custo Total Mensal Gasolina
#### Lucro Etanol= Ganhos Mensais totais - Custo Total Mensal Etanol
#### Lucro GNV= Ganhos Mensais totais - Custo Total Mensal GNV

