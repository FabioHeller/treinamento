package com.codenation.treinamento.entity;

import com.codenation.treinamento.annotation.ColumnAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {
    protected int idade;
    @ColumnAnnotation(position = 2, text = ("Nome da empresa é: "))
    protected String nome;
    @ColumnAnnotation(position = 1, text = ("Id da empresa é: "))
    protected Long id;
    @ColumnAnnotation(position = 3, text = ("Documento da empresa é: "))
    protected String documento;
    public Pessoa(){

    }
}
