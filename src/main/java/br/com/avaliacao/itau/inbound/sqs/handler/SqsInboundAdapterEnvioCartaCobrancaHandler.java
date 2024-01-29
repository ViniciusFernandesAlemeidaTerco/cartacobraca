package br.com.avaliacao.itau.inbound.sqs.handler;

import br.com.avaliacao.itau.core.domain.dto.cartacobranca.CartaCobrancaDTO;
import br.com.avaliacao.itau.core.port.outbound.CorePort;
import br.com.avaliacao.itau.core.utils.JsonUtil;
import br.com.avaliacao.itau.inbound.sqs.util.AbstractSQSProcessor;
import jakarta.jms.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SqsInboundAdapterEnvioCartaCobrancaHandler extends AbstractSQSProcessor {

    @Autowired
    private CorePort corePort;

    @Override
    public void processar(String json) {
        log.info("INICIO - SqsInboundAdapterEnvioCartaCobrancaHandler >> receberMensagem json {}", json);
        CartaCobrancaDTO cartaCobrancaDTO = JsonUtil.fromJson(json, CartaCobrancaDTO.class);
        corePort.enviarCartaCobranca(cartaCobrancaDTO);
        log.info("FINAL - SqsInboundAdapterEnvioCartaCobrancaHandler >> receberMensagem json {}", json);
    }

    @Override
    @JmsListener(destination = "${aws.sqs.inbound.queue.envio.carta.cobranca.name}")
    public void onMessage(Message message) {
        super.processarMensagem(message, this);
    }


}
