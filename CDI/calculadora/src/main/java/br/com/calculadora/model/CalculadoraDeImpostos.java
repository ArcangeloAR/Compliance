package br.com.calculadora.model;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class CalculadoraDeImpostos {

	private CalculadoraDeSalariosInterface calculadoraSalariosInterface;
	
	
	public CalculadoraDeImpostos() {

	}

	@Inject
	public CalculadoraDeImpostos(CalculadoraDeSalariosInterface calculadora) {
		System.out.println("Iniciando Calculadora de impostos...");
		calculadoraSalariosInterface = calculadora;
	}

	@PostConstruct
	public void init() {
		System.out.println("Calculadora de impostos pronta!");
	}

	public double calculaImpostoDeRenda(Funcionario funcionario){
		double salario = calculadoraSalariosInterface.calculaSalario(funcionario);

		//tabela de IR de 2013
		double aliquota = 0.0;
		double parcelaDeduzir = 0.0;

		//ifs estão de forma mais didática, na prática poderiam ser reduzidos
		if(salario <= 1710.78){
			aliquota = 0.0;
			parcelaDeduzir = 0.0;
		} else if(salario > 1710.78 && salario <= 2563.91){
			aliquota = 7.5/100;
			parcelaDeduzir = 128.31;
		} else if(salario > 2563.91 && salario <= 3418.59){
			aliquota = 15.0/100;
			parcelaDeduzir = 320.60;
		} else if(salario > 3418.59 && salario <= 4271.59){
			aliquota = 22.5/100;
			parcelaDeduzir = 577.0;
		} else if(salario > 4271.59){
			aliquota = 27.5/100;
			parcelaDeduzir = 790.58;
		}

		double impostoSemDesconto = salario * aliquota;

		return impostoSemDesconto - parcelaDeduzir;
	}
}