package br.com.calculadora.model;

import java.util.List;

import br.com.calculadora.qualificadores.Simulador;

import static br.com.calculadora.qualificadores.PlanoDeCargos.*;

@Simulador(planoDeCargos = VERSAO_2013)
public class SimuladoraCalculoFolhaPagamentoPlano2013 implements CalculadoraFolhaPagamento {
	
	@Override
	public Folha calculaFolha(List<Funcionario> funcionarios) {
		System.out.println("Simulação com plano de 2013");
		return null;
	}
}