package br.com.calculadora.model;

public class Funcionario {
	
	private String nome;
	
	private Cargo cargo;
	
	private Escolaridade escolaridade;
	
	private int anoAdmissao;
	
	
	public Funcionario() {
	}
	
	
	public Funcionario(String nome, Cargo cargo, Escolaridade escolaridade, int anoAdmissao) {
        this.nome = nome;
        this.cargo = cargo;
        this.escolaridade = escolaridade;
        this.anoAdmissao = anoAdmissao;
    }
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public int getAnoAdmissao() {
		return anoAdmissao;
	}

	public void setAnoAdmissao(int anoAdmissao) {
		this.anoAdmissao = anoAdmissao;
	}
	
    @Override
    public String toString() {
        return nome;
    }
	
}
