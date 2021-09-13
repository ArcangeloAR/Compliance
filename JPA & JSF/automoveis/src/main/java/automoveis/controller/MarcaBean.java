package automoveis.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import automoveis.entities.Marca;
import automovel.persistence.JPAUtil;

@SuppressWarnings("deprecation")
@ManagedBean
public class MarcaBean {

	private Marca marca = new Marca();
	private List<Marca> marcas;

	public String salvar() {
		EntityManager em = JPAUtil.getEntityManager();
		em.persist(marca);
		return "listar";
	}
	
	@PostConstruct
	public void carregaMarcas() {
		EntityManager em = JPAUtil.getEntityManager();
		marcas = em.createQuery("select m from Marca m", Marca.class).getResultList();
		em.close();
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

}
