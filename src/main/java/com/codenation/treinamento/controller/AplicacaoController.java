package com.codenation.treinamento.controller;


import com.codenation.treinamento.service.AplicationService;
import com.codenation.treinamento.service.impl.AplicacaoServiceImpl;

import java.math.BigDecimal;

public class AplicacaoController extends ArquivoController{
    private static AplicationService AplicationServiceImpl;

    public static void createUsuario(Long id, String nome, String documento, int idade, String login, String senha, Long idEmpresa, BigDecimal salario) throws Exception {
        AplicacaoServiceImpl.novoUsuario(id, nome, documento, idade, login, senha, idEmpresa, salario);
    }

    public static void createEmpresa(Long id, String nome, String documento, int vagas, String site) {
        AplicacaoServiceImpl.novaEmpresa(id, nome, documento, vagas, site);
    }

    public static void vinculaUsuarioEmpresa(String nomeUsuario, String nomeEmpresa) throws Exception {
        AplicacaoServiceImpl.vinculaUsuarioEmpresa(nomeUsuario, nomeEmpresa);
    }

    public static void listarUsuariosEmpresas(Long id, String nomeUsuario, String documentoUsuario, int idadeUsuario) {
        AplicacaoServiceImpl.findUsuarios(id, nomeUsuario, documentoUsuario, idadeUsuario);
    }



    public static void maiorSalarioCadaEmpresa() {
        AplicacaoServiceImpl.maiorSalarioCadaEmpresa();
    }

    public static BigDecimal maiorSalarioGeral() {
        return AplicacaoServiceImpl.maiorSalarioGeral();
    }

    public static void mediaSalarialCadaEmpresa() {
        AplicacaoServiceImpl.mediaSalarialCadaEmpresa();
    }

    public static void folhaTotalEmpresa() {
        AplicacaoServiceImpl.folhaTotalEmpresa();
    }

    public static void empresaMenorrCusto() {
        AplicacaoServiceImpl.empresaMenorCusto();
    }

    public static void mediaIdade() {
        AplicacaoServiceImpl.mediaIdade();
    }

    public static void listaOrdenadaPorIdadePorEmpresa() {
        AplicacaoServiceImpl.listaOrdenadaPorIdadePorEmpresa();
    }

}
