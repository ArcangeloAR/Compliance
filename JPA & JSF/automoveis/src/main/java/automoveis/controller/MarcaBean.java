package automoveis.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import javax.faces.view.ViewScoped;

import automoveis.entities.Marca;
import automovel.persistence.JPAUtil;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
public class MarcaBean {

	private Marca marca;
	private List<Marca> marcas;
	
	
	@PostConstruct
	public void init(){
		marca = new Marca();
	}
	

	public void salvar() {
		EntityManager em = JPAUtil.getEntityManager();
		em.persist(marca);
		
	}

	public List<Marca> getMarcas() {
		if (marcas == null) {
			marcas = JPAUtil.getEntityManager().createQuery("select m from Marca m", Marca.class).getResultList();
		}

		return marcas;
	}
	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
