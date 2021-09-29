package br.com.calculadora.events;

import javax.enterprise.event.Observes;

import org.slf4j.Logger;

import br.com.calculadora.model.Funcionario;

public class AgenciaDeEmpregos {
    
    public void ajudarFuncionarioDemitido(@Observes @Demissao Funcionario funcionario, Logger logger){
        logger.info("Ajudando {} a conseguir um novo emprego", funcionario);
    }
}