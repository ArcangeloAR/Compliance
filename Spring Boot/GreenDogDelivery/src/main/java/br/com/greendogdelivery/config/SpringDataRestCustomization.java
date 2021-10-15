package br.com.greendogdelivery.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

import br.com.greendogdelivery.model.Item;
import br.com.greendogdelivery.repository.ClienteRepository;


@Component
public class SpringDataRestCustomization implements RepositoryRestConfigurer
{

	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Item.class, ClienteRepository.class);
	}
}