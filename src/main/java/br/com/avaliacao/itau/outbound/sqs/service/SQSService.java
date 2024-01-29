package br.com.avaliacao.itau.outbound.sqs.service;

import br.com.avaliacao.itau.core.domain.dto.callbackcarta.CallBackAtualizaCobrancaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
@Slf4j
public class SQSService {

    @Value("${aws.sqs.outbound.transacao.carta.cobranca}")
    private String sqsTransacaoCartaCobranca;

    @Autowired
    private SqsClient sqsClientOutbound;

    public void enviarCallbackCartaCobraca(CallBackAtualizaCobrancaDTO callBackAtualizaCobrancaDTO) {
        this.send(callBackAtualizaCobrancaDTO.buildJson(), sqsTransacaoCartaCobranca, 0);
    }

    private void send(final String message, final String queueUrl, int delay) {

        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                                                                  .queueUrl(queueUrl)
                                                                  .messageBody(message)
                                                                  .delaySeconds(delay)
                                                                  .build();

        log.info("Enviando mensagem sendMessageRequest {}", sendMessageRequest);
        sqsClientOutbound.sendMessage(sendMessageRequest);
    }

}
