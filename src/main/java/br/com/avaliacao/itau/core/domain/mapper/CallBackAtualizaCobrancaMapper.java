package br.com.avaliacao.itau.core.domain.mapper;

import br.com.avaliacao.itau.core.domain.dto.callbackcarta.CallBackAtualizaCobrancaDTO;
import br.com.avaliacao.itau.core.domain.dto.callbackcarta.CallBackCartaCobrancaDTO;
import br.com.avaliacao.itau.core.domain.dto.cartacobranca.CartaCobrancaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallBackAtualizaCobrancaMapper {

    public static final String STATUS = "Erro de comunicação com parceiro. Carta não enviada";
    public static CallBackAtualizaCobrancaDTO convertAtualizaCartaCobrancaDTO(CartaCobrancaDTO cartaCobrancaDTO, CallBackCartaCobrancaDTO callBackCartaCobrancaDTO) {
        return CallBackAtualizaCobrancaDTO.builder()
                .idCLiente(cartaCobrancaDTO.getDadosClienteDTO().getIdCLiente())
                .idProtudo(cartaCobrancaDTO.getDadosProdutoCobrancaDTO().getIdProtudo())
                .idCallBack(callBackCartaCobrancaDTO.getIdCallBack())
                .status(callBackCartaCobrancaDTO.getStatus() != null ? callBackCartaCobrancaDTO.getStatus() : STATUS )
                .build();

    }

}
