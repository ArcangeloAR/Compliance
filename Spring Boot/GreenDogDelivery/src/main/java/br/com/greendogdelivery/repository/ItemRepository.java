package br.com.greendogdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.greendogdelivery.model.Item;

@RepositoryRestResource(collectionResourceRel = "itens", path = "itens")
public interface ItemRepository extends JpaRepository<Item, Long> {
	
}
