package br.com.calculadora.controller;

import javax.inject.Named;

import br.com.calculadora.model.Folha;

@Named
public class CalculadoraFolhaBean {
	
	private Folha ultimoCalculo;

	public Folha getUltimoCalculo() {
		return ultimoCalculo;
	}
	
}

