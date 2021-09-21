package br.com.calculadora.model;

public interface CalculadoraDeSalariosInterface {
	
	double calculaSalario(Funcionario funcionario);
    	void setTabelaDeReferenciaSalarial(TabelaDeReferenciaSalarial tabela);
	
}