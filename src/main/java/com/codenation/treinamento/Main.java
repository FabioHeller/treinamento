package com.codenation.treinamento;

import com.codenation.treinamento.controller.AplicacaoController;
import com.codenation.treinamento.execptions.codenationException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
     /*
    public static void main(String args[]) throws Exception {


        AplicacaoController.carregarArquivoUsuario("C:\\Users\\Fabio\\Downloads\\treinamento\\arquivos\\usuarios.txt");
        AplicacaoController.carregarArquivoEmpresa("C:\\Users\\Fabio\\Downloads\\treinamento\\arquivos\\empresa.txt");
        AplicacaoController.maiorSalarioCadaEmpresa();
        AplicacaoController.maiorSalarioGeral();
        AplicacaoController.mediaSalarialCadaEmpresa();
        AplicacaoController.folhaTotalEmpresa();
        AplicacaoController.empresaMenorrCusto();
        AplicacaoController.mediaIdade();
        AplicacaoController.listaOrdenadaPorIdadePorEmpresa();

        try {
            AplicacaoController.createEmpresa(5L, "Empresa 01", "ADS1231", 2, "www.tralaa.com");
        } catch (codenationException e) {
            e.getMessage();
        }
        try {
            AplicacaoController.createEmpresa(6L, "Empresa 02", "ADS1232", 4, "www.tralaa.com");
        } catch (codenationException e) {
            e.getMessage();
        }
        try {
            AplicacaoController.createEmpresa(7L, "Empresa 03", "ADS1243", 5, "www.tralaa.com");
        } catch (codenationException e) {
            e.getMessage();
        }
        try {
            AplicacaoController.createUsuario(
                    1L, "Thiago", "123456789", 31, "LGthigo", "123456", 0L, 2000.00);
        } catch (codenationException e) {
            e.getMessage();
        }
        try {
            AplicacaoController.createUsuario(
                    2L, "Fabio", "1234567891", 31, "LGfabio", "123456", 0L,2002.00);
        } catch (codenationException e) {
            e.getMessage();
        }
        try {
            AplicacaoController.createUsuario(
                    3L, "Cintia", "1234567892", 31, "LGcintia", "123456", 0L,2002.00);
        } catch (codenationException e) {
            e.getMessage();
        }
        try {
            AplicacaoController.createUsuario(
                    4L, "Bruno", "1234567893", 31, "LGbruno", "123456", 0L,2002.00);
        } catch (codenationException e) {
            e.getMessage();
        }
        try {
            AplicacaoController.createUsuario(
                    1L, "Thiago", "123456789", 31, "LGthigo", "123456", 0L,2002.00);
        } catch (codenationException e) {
            e.getMessage();
        }
        try {
            AplicacaoController.createUsuario(
                    2L, "", "123456789", 31, "fabio", "123456", 0L,2002.00);
        } catch (codenationException e) {
            e.getMessage();
        }
        try {
            AplicacaoController.vinculaUsuarioEmpresa("Thiago", "Empresa 01");
        } catch (codenationException e) {
            e.getMessage();
        }
        try {
            AplicacaoController.vinculaUsuarioEmpresa("Thiago", "Empresa 00");
        } catch (codenationException e) {
            e.getMessage();
        }
        try {
            AplicacaoController.vinculaUsuarioEmpresa("Fabio", "Empresa 01");
        } catch (codenationException e) {
            e.getMessage();
        }
        try {
            AplicacaoController.vinculaUsuarioEmpresa("Cintia", "Empresa 01");
        } catch (codenationException e) {
            e.getMessage();
        }
        try {
            AplicacaoController.listarUsuariosEmpresas(null, "Fabio", null, 0);
        }catch  (codenationException e) {
            e.getMessage();
        }

    }*/
}
