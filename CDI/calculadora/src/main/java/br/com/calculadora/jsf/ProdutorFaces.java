package br.com.calculadora.jsf;

import java.util.Map;

import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.annotation.ApplicationMap;
import javax.faces.annotation.RequestMap;
import javax.faces.annotation.RequestParameterMap;
import javax.faces.annotation.SessionMap;
import javax.faces.application.Application;

public class ProdutorFaces {

	@Produces
	private FacesContext context = FacesContext.getCurrentInstance();

	@Produces
	private ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

	@Produces
	private Application application = FacesContext.getCurrentInstance().getApplication();

	@Produces
	@ApplicationMap
	public Map<String, Object> disponibilizaApplicationMap(ExternalContext ec) {
		return ec.getApplicationMap();
	}

	@Produces
	@SessionMap
	public Map<String, Object> disponibilizaSessionMap(ExternalContext ec) {
		return ec.getSessionMap();
	}

	@Produces
	@RequestMap
	public Map<String, Object> disponibilizaRequestMap(ExternalContext ec) {
		return ec.getRequestMap();
	}

	@Produces
	@RequestParameterMap
	public Map<String, String> disponibilizaParameterMap(ExternalContext ec) {
		return ec.getRequestParameterMap();
	}

}