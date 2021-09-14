package automoveis.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import org.primefaces.model.LazyDataModel;

import automoveis.entities.Modelo;
import automovel.persistence.JPAUtil;
import automovel.persistence.QueryDataModel;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
public class ModeloBean {

	private Modelo modelo;
	private List<Modelo> modelos;

	private LazyDataModel<Modelo> lazyDataModel;

	@PostConstruct
	public void init() {
		modelo = new Modelo();
	}

	public String salvar(Modelo modelo) {
		EntityManager em = JPAUtil.getEntityManager();
		em.persist(modelo);
		return "listar";
	}

	public LazyDataModel<Modelo> getLazyDataModel() {
		if (lazyDataModel == null) {
			String jpql = "select m from Modelo m";
			lazyDataModel = new QueryDataModel<Modelo>(jpql, jpql);
		}

		return lazyDataModel;
	}

	public List<Modelo> getModelos() {
		if (modelos == null) {
			modelos = JPAUtil.getEntityManager().createQuery("select m from Modelo m", Modelo.class).getResultList();
		}

		return modelos;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

}
