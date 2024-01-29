package br.com.avaliacao.itau.core.port.outbound;

import br.com.avaliacao.itau.core.domain.dto.cartacobranca.CartaCobrancaDTO;

public interface CorePort {

    void enviarCartaCobranca(CartaCobrancaDTO cartaCobrancaDTO);

}
