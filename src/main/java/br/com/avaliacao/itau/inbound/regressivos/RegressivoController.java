package br.com.avaliacao.itau.inbound.regressivos;


import br.com.avaliacao.itau.core.domain.dto.cartacobranca.CartaCobrancaDTO;
import br.com.avaliacao.itau.core.excepiton.RetentativaTransacaoException;
import br.com.avaliacao.itau.core.port.outbound.CorePort;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Api(tags = "Controller para Testes Regressivos")
@RequestMapping("/v1/cartacobrancaregressivo")
public class RegressivoController {

    @Autowired
    private CorePort corePort;

    @Operation(summary = "Envia carta de cobrança para parceiro regressivo", method = "POST")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/testeIntegracaoCartaCobraca",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            headers = "Content-Type=application/json")
    ResponseEntity<String> enviaCartaCobrancaRegressivo(@RequestBody CartaCobrancaDTO cartaCobrancaDTO) {
        log.info("INICIO - Teste Regressivo Aprovada >> Mensagem Recebida no Objeto {}", cartaCobrancaDTO);
        try {
            corePort.enviarCartaCobranca(cartaCobrancaDTO);
            log.info("FINAL -  Teste Regressivo Aprovada>> Mensagem Recebida no Objeto {}", cartaCobrancaDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (RetentativaTransacaoException e) {
        	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
  
    }


}
