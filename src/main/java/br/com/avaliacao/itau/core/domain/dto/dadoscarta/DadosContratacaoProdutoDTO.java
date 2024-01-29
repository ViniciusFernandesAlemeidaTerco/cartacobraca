package br.com.avaliacao.itau.core.domain.dto.dadoscarta;

import br.com.avaliacao.itau.core.domain.enums.CanalCompraEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosContratacaoProdutoDTO {

    private String nomeProduto;
    private LocalDateTime dataAquisicaoProduto;
    private CanalCompraEnum canalCompraEnum;
    private BigDecimal valorCobrancaProduto;

}
