package com.codenation.treinamento.controller;

import com.codenation.treinamento.service.impl.AplicacaoServiceImpl;

public class ArquivoController {
    public static void carregarArquivoUsuario(String path) {
        AplicacaoServiceImpl.carregarArquivoUsuario(path);
    }

    public static void carregarArquivoEmpresa(String path) {
        AplicacaoServiceImpl.carregarArquivoEmpresa(path);
    }
}
