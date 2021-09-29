package br.com.calculadora.events;

import java.lang.annotation.Annotation;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;

import br.com.calculadora.model.Funcionario;


@Model
public class GerenciadorFuncionarioBean {
    
    private Funcionario funcionario;
    private TipoDesligamento tipoDesligamento;
    
    @Inject
    private Event<Funcionario> eventoFuncionario;
    
    @Inject
    private Event<Funcionario> eventoDesligamento;
    
    @PostConstruct
    public void init(){
        funcionario = new Funcionario();
    }

    
    public TipoDesligamento[] tiposDesligamento(){
        return TipoDesligamento.values();
    }
    
    public void cadastrarFuncionario(){
        // Salvar funcionario no banco
        eventoFuncionario.fire(funcionario);
    }
    
    public void desligarFuncionario(){
        
        Annotation qualificador = null;
        if(tipoDesligamento == TipoDesligamento.APOSENTADORIA){
            // Faz a lógica de aposentadoria
            qualificador = new DesligamentoQualifier(TipoDesligamento.APOSENTADORIA){};
        }
        else if(tipoDesligamento == TipoDesligamento.DEMISSAO){
            qualificador = new DesligamentoQualifier(TipoDesligamento.DEMISSAO){};
        }
       
        Event<Funcionario> eventoQualificado = eventoDesligamento.select(qualificador);
        
        eventoQualificado.fire(funcionario);
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public TipoDesligamento getTipoDesligamento() {
        return tipoDesligamento;
    }

    public void setTipoDesligamento(TipoDesligamento tipoDesligamento) {
        this.tipoDesligamento = tipoDesligamento;
    }
    
}