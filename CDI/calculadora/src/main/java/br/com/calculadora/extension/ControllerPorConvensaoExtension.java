package br.com.calculadora.extension;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerPorConvensaoExtension implements Extension {
	private Logger logger = LoggerFactory.getLogger(ControllerPorConvensaoExtension.class);

	void configuraControllers(
	@Observes ProcessAnnotatedType pat) {
	AnnotatedType at = pat.getAnnotatedType();
	logger.info("Passando pelo AnnotatedType {}", at);
	}
}