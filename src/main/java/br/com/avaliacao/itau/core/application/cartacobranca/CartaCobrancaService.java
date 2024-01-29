package br.com.avaliacao.itau.core.application.cartacobranca;

import br.com.avaliacao.itau.core.domain.dto.callbackcarta.CallBackCartaCobrancaDTO;
import br.com.avaliacao.itau.core.domain.dto.cartacobranca.CartaCobrancaDTO;
import br.com.avaliacao.itau.core.domain.mapper.CallBackAtualizaCobrancaMapper;
import br.com.avaliacao.itau.outbound.feing.RestOutboundTransacaoParceiroFeign;
import br.com.avaliacao.itau.outbound.sqs.service.SQSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CartaCobrancaService {

    @Autowired
    private RestOutboundTransacaoParceiroFeign restOutboundTransacaoParceiroFeign;

    @Autowired
    private SQSService sqsService;


    public void enviarCartaCobranca(CartaCobrancaDTO cartaCobrancaDTO) {
    // Realizar qualquer tipo de processamento ou validação necessária.
       ResponseEntity<CallBackCartaCobrancaDTO> callBackCartaCobrancaDTOResponseEntity = restOutboundTransacaoParceiroFeign.enviaCartaCobraca(cartaCobrancaDTO);
       sqsService.enviarCallbackCartaCobraca(CallBackAtualizaCobrancaMapper.convertAtualizaCartaCobrancaDTO(cartaCobrancaDTO, retornoParceiro(callBackCartaCobrancaDTOResponseEntity)));
    }

    private CallBackCartaCobrancaDTO retornoParceiro (ResponseEntity<CallBackCartaCobrancaDTO> callBackCartaCobrancaDTOResponseEntity){
        CallBackCartaCobrancaDTO callBackCartaCobrancaDTO = CallBackCartaCobrancaDTO.builder().build();
        if (callBackCartaCobrancaDTOResponseEntity.getStatusCode().is2xxSuccessful()){
            callBackCartaCobrancaDTO = callBackCartaCobrancaDTOResponseEntity.getBody();
        }
        return callBackCartaCobrancaDTO;
    }


}
