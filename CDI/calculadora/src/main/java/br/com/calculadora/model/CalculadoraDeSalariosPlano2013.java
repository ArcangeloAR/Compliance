package br.com.calculadora.model;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;

@Alternative @Priority(Interceptor.Priority.APPLICATION + 1)
public class CalculadoraDeSalariosPlano2013 implements CalculadoraDeSalarios {
	// O novo código, que nesse exemplo não influencia no entendimento
	public double calculaSalario(Funcionario funcionario) {
		return 0.0;
	}

	@Override
	public void setTabelaDeReferenciaSalarial(TabelaDeReferenciaSalarial tabela) {
		// TODO Auto-generated method stub

	}
}