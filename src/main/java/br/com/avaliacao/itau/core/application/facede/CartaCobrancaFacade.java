package br.com.avaliacao.itau.core.application.facede;

import br.com.avaliacao.itau.core.application.cartacobranca.CartaCobrancaService;
import br.com.avaliacao.itau.core.domain.dto.cartacobranca.CartaCobrancaDTO;
import br.com.avaliacao.itau.core.port.outbound.CorePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CartaCobrancaFacade implements CorePort {

	@Autowired
	private CartaCobrancaService cartaCobrancaService;


	@Override
	public void enviarCartaCobranca(CartaCobrancaDTO cartaCobrancaDTO) {
		log.info("INICIO ENVIO CARTA COBRAÇA - ID: {}.", cartaCobrancaDTO.getIdCartaCobranca());
		cartaCobrancaService.enviarCartaCobranca(cartaCobrancaDTO);
		log.info("FINALIZADO ENVIO CARTA COBRAÇA.");
	}

}
