package br.com.avaliacao.itau.core.application.facede;

import br.com.avaliacao.itau.core.application.cartacobranca.CartaCobrancaService;
import br.com.avaliacao.itau.core.domain.dto.cartacobranca.CartaCobrancaDTO;
import br.com.avaliacao.itau.core.utils.UtilTeste;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CartaCobrancaFacadeTest {

    @InjectMocks
    private CartaCobrancaFacade service;

    @Mock
    private CartaCobrancaService cartaCobrancaService;


    @Test
    void triarTransacaoAprovada() {
        CartaCobrancaDTO cartaCobrancaDTO = UtilTeste.criarCartaCobranca();
        service.enviarCartaCobranca(cartaCobrancaDTO);
        verify(cartaCobrancaService, times(1)).enviarCartaCobranca(cartaCobrancaDTO);
    }


}