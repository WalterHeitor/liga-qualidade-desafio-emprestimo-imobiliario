package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.processor.MessageProcessor;

import java.util.List;

public class Solucao {
	
  public static String processMessages(List<String> messages) {
	  
      return new MessageProcessor(messages).execute();
  }
}