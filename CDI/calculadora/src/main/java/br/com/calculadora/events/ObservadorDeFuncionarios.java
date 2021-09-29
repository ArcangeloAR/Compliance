package br.com.calculadora.events;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.Topic;

import org.slf4j.Logger;

import br.com.calculadora.model.Funcionario;

@Stateless
public class ObservadorDeFuncionarios {
    
    @Inject
    private JMSContext jmsContext;
    
    @Resource(mappedName = "jms/demissaoTopic")
    private Topic topicoDemissao;
    
    @Asynchronous
     public void notificaAgenciaDeEmprego(@Observes @Desligamento(TipoDesligamento.DEMISSAO) Funcionario funcionario, Logger logger) throws Exception{
        logger.info("Enviando demissão do funcionario {} para agencia de empregos", funcionario);
        jmsContext.createProducer().send(topicoDemissao, funcionario);
    }
    
}