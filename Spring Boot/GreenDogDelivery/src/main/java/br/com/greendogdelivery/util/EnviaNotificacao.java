package br.com.greendogdelivery.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.greendogdelivery.dto.Notificacao;
import br.com.greendogdelivery.model.Cliente;
import br.com.greendogdelivery.model.Pedido;

@Component
public class EnviaNotificacao {
	
	@Autowired
	Notificacao notificacao;

	public void enviaEmail(Cliente cliente, Pedido pedido) {
		if (notificacao.envioAtivo()) {
			/* codigo de envio */
			System.out.println("Notificacao	enviada!");
		} else {
			System.out.println("Notificacao	desligada!");
		}
	}
}