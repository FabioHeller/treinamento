package com.codenation.treinamento;

import com.codenation.treinamento.annotation.Metodos;
import com.codenation.treinamento.controller.AplicacaoController;
import com.codenation.treinamento.service.impl.AplicacaoServiceImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.*;

@SpringBootTest
@EnableAutoConfiguration
class TreinamentoApplicationTests extends TreinamentoApplication{

	private static Logger LOG = LoggerFactory.getLogger(TreinamentoApplicationTests.class);
	@Test
	void contextLoads() {
		for (Method declareMethods : AplicacaoServiceImpl.class.getDeclaredMethods()){
			if(declareMethods.getDeclaredAnnotation(Metodos.class) != null){
	//switch (declareMethods.getAnnotation(Metodos.class).text()){
		LOG.info(declareMethods.getAnnotation(Metodos.class).text());
	//}
			}
		}
	}

}
