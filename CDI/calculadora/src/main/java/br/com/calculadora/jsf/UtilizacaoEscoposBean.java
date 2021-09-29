package br.com.calculadora.jsf;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ApplicationMap;
import javax.faces.annotation.RequestMap;
import javax.faces.annotation.RequestParameterMap;
import javax.faces.annotation.SessionMap;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UtilizacaoEscoposBean {
    
    @Inject @ApplicationMap
    private Map<String, Object> applicationMap;
    
    @Inject @SessionMap
    private Map<String, Object> sessionMap;
    
    @Inject @RequestMap
    private Map<String, Object> requestMap;
    
    @Inject @RequestParameterMap
    private Map<String, String> requestParameterMap;
   
}