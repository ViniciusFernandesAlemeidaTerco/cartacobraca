package br.com.avaliacao.itau.inbound.sqs.util;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@Service
public abstract class AbstractSQSProcessor implements SqsMessageProcessor, MessageListener {

    private static final String OCORREU_ERRO_PROCESSAR_MENSAGEM = "Ocorreu um erro ao processar a mensagem. JMSMessageID >> {} JMSXDeliveryCount >> {} Exception >> {}";

    protected void processarMensagem(Message message, SqsMessageProcessor processor) {
        String messageId = null;
        int deliveryCount = 0;
        try {

            if (message instanceof TextMessage m) {
                messageId = message.getJMSMessageID();
                deliveryCount = message.getIntProperty("JMSXDeliveryCount");

                String mensagem = m.getText();
                processor.processar(mensagem);
                lerMensagemDaFila(message);
            }
        }  catch (HttpClientErrorException e) {
        	log.error("Ocorreu um erro que deve realizar um retry {}, message{}", e.getMessage(), message);
            log.error(OCORREU_ERRO_PROCESSAR_MENSAGEM, messageId, deliveryCount, e);
        } catch (Exception e) {
            log.error(OCORREU_ERRO_PROCESSAR_MENSAGEM, messageId, deliveryCount, e);
            lerMensagemDaFila(message);
        }
    }

    private void lerMensagemDaFila(Message message) {
        try {
            message.acknowledge();
        } catch (JMSException e1) {
            log.error("Erro ao ler da fila", e1);
        }
    }

}
