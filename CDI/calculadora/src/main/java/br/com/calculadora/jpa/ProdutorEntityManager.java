package br.com.calculadora.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutorEntityManager {
	
	@Produces
	@ApplicationScoped
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");

	@Produces
	@RequestScoped
	public EntityManager criaEntityManager(EntityManagerFactory factory) {
		return factory.createEntityManager();
	}

	public void fechaEntityManager(@Disposes EntityManager entityManager) {
		entityManager.close();
	}
}