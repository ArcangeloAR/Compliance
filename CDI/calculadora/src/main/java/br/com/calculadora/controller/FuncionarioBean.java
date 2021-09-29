package br.com.calculadora.controller;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.calculadora.model.Funcionario;

@Stateless
public class FuncionarioBean {
	
	@Inject
	private EntityManager em;

	public void salvarFuncionario(Funcionario funcionario) {
		em.persist(funcionario);
	}
}
