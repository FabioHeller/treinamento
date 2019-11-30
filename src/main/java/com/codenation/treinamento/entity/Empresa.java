package com.codenation.treinamento.entity;

import com.codenation.treinamento.annotation.ColumnAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empresa extends Pessoa{
    @ColumnAnnotation(position = 4, text = ("Vagas da empresa é: "))
    private int vagas;
    @ColumnAnnotation(position = 5, text = ("Site da empresa é: "))
    private String site;
    public Empresa(Long id, String nome, String documento, int vagas, String site){
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.vagas = vagas;
        this.site = site;
    }
}
