package com.codenation.treinamento;

import com.codenation.treinamento.controller.AplicacaoController;
import com.codenation.treinamento.controller.CompanyController;
import com.codenation.treinamento.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
@EnableScheduling
public class TreinamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreinamentoApplication.class, args);
/*
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("treinamento");
		factory.close();
		//CompanyController.createCompany();
		//UserController.createUser();



		AplicacaoController.carregarArquivoUsuario("C:\\Users\\Fabio\\Downloads\\treinamento\\arquivos\\usuarios.txt");
		AplicacaoController.carregarArquivoEmpresa("C:\\Users\\Fabio\\Downloads\\treinamento\\arquivos\\empresa.txt");
		AplicacaoController.maiorSalarioCadaEmpresa();
		AplicacaoController.maiorSalarioGeral();
		AplicacaoController.mediaSalarialCadaEmpresa();
		AplicacaoController.folhaTotalEmpresa();
		AplicacaoController.empresaMenorrCusto();
		AplicacaoController.mediaIdade();
		AplicacaoController.listaOrdenadaPorIdadePorEmpresa();

		 */
	}

}
