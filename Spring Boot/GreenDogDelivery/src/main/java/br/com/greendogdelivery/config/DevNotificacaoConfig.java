package br.com.greendogdelivery.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.greendogdelivery.dto.Notificacao;

@Component
@Profile("!prod")
public class DevNotificacaoConfig implements Notificacao {
	
	@Override
	public boolean envioAtivo() {
		return false;
	}
	
}