package br.com.avaliacao.itau.core.domain.dto.callbackcarta;

import br.com.avaliacao.itau.core.utils.JsonUtil;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class CallBackAtualizaCobrancaDTO {

    private int idCLiente;
    private int idProtudo;
    private int idCallBack;
    private String status;

    public String buildJson() {
        return JsonUtil.toJson(this);
    }

}
