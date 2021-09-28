package br.com.calculadora.interceptador;

import java.lang.reflect.Method;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;

@Interceptor
@Auditavel
@Priority(Interceptor.Priority.APPLICATION)
public class Auditor {

	@Inject
	private Logger logger;

	@AroundInvoke
	public Object auditar(InvocationContext context) throws Exception {
		// Faz processamento antes
		logger.info("faz processamento anterior");
		Method method = context.getMethod();
		Object target = context.getTarget();
		Object[] params = context.getParameters();
		logger.info(String.format("auditando o método: '%s' " + "do objeto: '%s' " + "com os parâmetros: '%s'", method,
				target, params));
		// Chama o método original
		logger.info("chama método original");
		Object retorno = context.proceed();
		// Faz processamento posterior
		logger.info("faz processamento posterior");
		return retorno;
	}
}
