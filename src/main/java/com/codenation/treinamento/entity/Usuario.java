package com.codenation.treinamento.entity;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Usuario extends Pessoa{
    private String login;
    private String senha;
    private Long idEmpresa;
    private BigDecimal salario;

    public Usuario (Long id, String nome, String documento, int idade, String login, String senha, Long idEmpresa, BigDecimal salario){
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.idade = idade;
        this.login  =login;
        this.senha = senha;
        this.idEmpresa = idEmpresa;
        this.salario = salario;
    }
}
