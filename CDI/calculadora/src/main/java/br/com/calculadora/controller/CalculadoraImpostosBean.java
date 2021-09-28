package br.com.calculadora.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.calculadora.interceptador.Auditavel;
import br.com.calculadora.model.CalculadoraDeImpostos;
import br.com.calculadora.model.Funcionario;
import br.com.calculadora.model.FuncionarioBuilder;

@Named @RequestScoped @Auditavel
public class CalculadoraImpostosBean {

	@Inject
	private CalculadoraDeImpostos calculadoraImpostos;
	
	private double salarioBase;
	
	private double imposto;

	public CalculadoraDeImpostos getCalculadoraImpostos() {
		return calculadoraImpostos;
	}

	public void setCalculadoraImpostos(CalculadoraDeImpostos calculadoraImpostos) {
		this.calculadoraImpostos = calculadoraImpostos;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}

	public CalculadoraImpostosBean() {
		System.out.println("Instanciando a CalculadoraImpostosBean...");
	}

	@PostConstruct
	public void ok() {
		System.out.println("CalculadoraImpostosBean pronta.");
	}

	public void calculaImposto() {

		Funcionario funcionario = new FuncionarioBuilder().comSalarioBaseDe(salarioBase).build();

		System.out.println("Efetuando o cálculo.");

		System.out.println("Salário base: " + salarioBase);

		// A calculadora de IR usa outra classe para calcular o salário
		imposto = calculadoraImpostos.calculaImpostoDeRenda(funcionario);

		System.out.println("valor do imposto: " + imposto);
		System.out.println("Fim.");
	}
}
