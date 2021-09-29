package br.com.calculadora.events;

import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;

import br.com.calculadora.model.Funcionario;

@MessageDriven(mappedName = "jms/demissaoTopic") //criar topico no GlassFish
public class AgenciaDeEmpregosMessageBean implements MessageListener {

    @Inject @Demissao
    private Event<Funcionario> eventoDemissao;
    
    @Inject
    private Logger logger;
    
    @Override
    public void onMessage(Message message) {
        try {
            Funcionario funcionario = message.getBody(Funcionario.class);
            
            logger.info("Recebida a demissão do funcionario {} via JMS", funcionario);
            
            eventoDemissao.fire(funcionario);
            
        } catch (JMSException ex) {
            logger.error("Erro ao ler a mensagem via JMS", ex);
        }
    }
    
}
