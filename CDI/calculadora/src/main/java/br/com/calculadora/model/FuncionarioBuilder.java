package br.com.calculadora.model;

import java.util.Calendar;

public class FuncionarioBuilder {

	private int anoAdmissao;
	
	private Escolaridade escolaridadeFuncionario;
	
	private Escolaridade escolaridadeCargo;
	
	private double salarioBase;
	
	
	public FuncionarioBuilder() {
		escolaridadeCargo = Escolaridade.SUPERIOR;
		escolaridadeFuncionario = Escolaridade.SUPERIOR;
		anoAdmissao = Calendar.getInstance().get(Calendar.YEAR);
	}

	public FuncionarioBuilder comSalarioBaseDe(double salarioBase) {
		this.salarioBase = salarioBase;
		return this;
	}

	public Funcionario build() {
		Cargo cargo = new Cargo(salarioBase, escolaridadeCargo);
		return new Funcionario(cargo, escolaridadeFuncionario, anoAdmissao);
	}
}