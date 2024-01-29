package br.com.avaliacao.itau.core.application.cartacobranca;

import br.com.avaliacao.itau.core.domain.dto.callbackcarta.CallBackCartaCobrancaDTO;
import br.com.avaliacao.itau.core.domain.dto.cartacobranca.CartaCobrancaDTO;
import br.com.avaliacao.itau.core.utils.UtilTeste;
import br.com.avaliacao.itau.outbound.feing.RestOutboundTransacaoParceiroFeign;
import br.com.avaliacao.itau.outbound.sqs.service.SQSService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CartaCobrancaServiceTest {

    @InjectMocks
    private CartaCobrancaService service;

    @Mock
    private RestOutboundTransacaoParceiroFeign restOutboundTransacaoParceiroFeign;


    @Mock
    private SQSService sqsService;

    @Test
    void enviarCartaCobranca() {
        CartaCobrancaDTO cartaCobrancaDTO = UtilTeste.criarCartaCobranca();
        ResponseEntity<CallBackCartaCobrancaDTO> callBackCartaCobrancaDTOResponseEntity = UtilTeste.criarCallBackCartaCobrancaDTOResponseEntity();

        when(restOutboundTransacaoParceiroFeign.enviaCartaCobraca(cartaCobrancaDTO)).thenReturn(callBackCartaCobrancaDTOResponseEntity);

        service.enviarCartaCobranca(cartaCobrancaDTO);

        verify(restOutboundTransacaoParceiroFeign, times(1)).enviaCartaCobraca(cartaCobrancaDTO);
        verify(sqsService, times(1)).enviarCallbackCartaCobraca(UtilTeste.criarCallBackAtualizaCobranca());
        assertNotNull(cartaCobrancaDTO);
    }


}
