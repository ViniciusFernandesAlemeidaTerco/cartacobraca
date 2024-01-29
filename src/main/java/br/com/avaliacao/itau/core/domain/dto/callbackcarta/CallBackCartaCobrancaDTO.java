package br.com.avaliacao.itau.core.domain.dto.callbackcarta;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CallBackCartaCobrancaDTO {

    private int idCallBack;
    private String status;

}
