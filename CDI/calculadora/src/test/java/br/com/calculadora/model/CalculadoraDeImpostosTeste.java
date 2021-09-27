package br.com.calculadora.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.calculadora.model.Funcionario;

public class CalculadoraDeImpostosTeste {

	@Test
	public void testaCalculoIRNaSegundaFaixaDeContribuicao(){
		Funcionario funcionario = new Funcionario();

		CalculadoraDeSalarios calcSalariosMock = 
							new CalculadoraDeSalariosMock(3000.0);

		CalculadoraDeImpostos calculadoraImpostos = new CalculadoraDeImpostos(calcSalariosMock);

		//a calculadora de IR usa outra classe para calcular o salário
		double imposto = calculadoraImpostos.calculaImpostoDeRenda(funcionario);

		Assert.assertEquals(129.4, imposto, 0.0001);
	}
}