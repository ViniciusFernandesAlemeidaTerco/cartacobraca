package br.com.avaliacao.itau.inbound.sqs.util;

public interface SqsMessageProcessor {

    void processar(String mensagem);
}
