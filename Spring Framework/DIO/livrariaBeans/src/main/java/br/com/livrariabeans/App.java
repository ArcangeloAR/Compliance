package br.com.livrariabeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		Autor autor = factory.getBean(Autor.class);
		
		Livro livro = factory.getBean(Livro.class);
		livro.setNome("Teste");
		livro.setCodigo("A001");
		autor.setNome("Testador");
		
		livro.exibir();
		
		((AbstractApplicationContext) factory).close();
		
	}

}
