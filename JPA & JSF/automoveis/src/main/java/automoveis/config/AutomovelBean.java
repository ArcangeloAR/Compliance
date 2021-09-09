package automoveis.config;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import automoveis.model.Automovel;


@SuppressWarnings("deprecation")
@ManagedBean
public class AutomovelBean {

	private Automovel automovel = new Automovel();

	private List<Automovel> automoveis;

	@SuppressWarnings("unchecked")
	public List<Automovel> getAutomoveis() {
		if (this.automoveis == null) {
			EntityManager em = JPAUtil.getEntityManager();
			Query q = em.createQuery("SELECT a FROM Automovel a", Automovel.class);
			this.automoveis = q.getResultList();
			em.close();
		}
		return automoveis;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public void salva(Automovel automovel) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();

		em.persist(automovel);

		em.getTransaction().commit();
		em.close();
	}

	public void excluir(Automovel automovel) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(automovel);
		tx.commit();
		em.close();
	}
}
