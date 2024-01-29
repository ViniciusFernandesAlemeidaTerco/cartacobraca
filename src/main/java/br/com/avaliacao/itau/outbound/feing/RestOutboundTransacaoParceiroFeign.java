package br.com.avaliacao.itau.outbound.feing;

import br.com.avaliacao.itau.core.domain.dto.callbackcarta.CallBackCartaCobrancaDTO;
import br.com.avaliacao.itau.core.domain.dto.cartacobranca.CartaCobrancaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Parceiro Carta de Cobrança", description = "Endpoints para envio de carta de cobraça para parceiro.")
@FeignClient(value = "Comunicacao-Transacao-Parceiro", url = "${aws.rest.outbound.comunicacao.transacao.parceiro}")
public interface RestOutboundTransacaoParceiroFeign {
	
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                         description = "Envio feito com sucesso.",
                         content = @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = CartaCobrancaDTO.class))),
            @ApiResponse(responseCode = "400",
                         description = "Solicitação não Processada.",
                         content = @Content(mediaType = "/")),
            @ApiResponse(responseCode = "500",
                    description = "Erro Interno.",
                    content = @Content(mediaType = "/"))
    })
    @Operation(summary = "Envia transação para parceiro.", method = "POST")
    @PostMapping(value = "/cartacobranca",
                 consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE,
                 headers = "Content-Type=application/json")
    ResponseEntity<CallBackCartaCobrancaDTO> enviaCartaCobraca(@RequestBody CartaCobrancaDTO cartaCobrancaDTO);



}
