package automoveis.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;

import automoveis.entities.Modelo;
import automovel.persistence.QueryDataModel;

@SuppressWarnings("deprecation")
@ManagedBean @ViewScoped
public class ModeloBean {
	
	private LazyDataModel<Modelo> modelosLazyDataModel;
	
	public LazyDataModel<Modelo> getModelosLazyDataModel() {
		if (modelosLazyDataModel == null) {
			String jpql = "select m from Modelo m";
			String count = "select count(m.id) from Modelo m";
			modelosLazyDataModel = new
			QueryDataModel<Modelo>(jpql, count);
	}
		return modelosLazyDataModel;
	}
	
}
