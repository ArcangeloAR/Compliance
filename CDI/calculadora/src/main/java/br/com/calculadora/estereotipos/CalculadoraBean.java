package br.com.calculadora.estereotipos;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import br.com.calculadora.interceptador.Auditavel;
import br.com.calculadora.interceptador.Rastreavel;

@Stereotype
@Named @RequestScoped
@Auditavel @Rastreavel
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CalculadoraBean {
	
}