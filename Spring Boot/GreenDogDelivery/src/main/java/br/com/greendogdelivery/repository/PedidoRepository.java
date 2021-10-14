package br.com.greendogdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.greendogdelivery.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>	{
	
}
