package br.com.avaliacao.itau.inbound.sqs.config;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

@Configuration
public class SqsConfiguration {

    @Value("${aws.sqs.queue.concurrency}")
    private String concurrency;

    @Value("${aws.sqs.queue.wait.time.seconds}")
    private Long waitTimeSeconds;

    @Value("${aws.sqs.queue.number.messages.receive}")
    private Integer numberOfMessagesToReceive;

    private ConnectionFactory connectionFactory;

    SqsConfiguration() {
        this.connectionFactory = new SQSConnectionFactory(new ProviderConfiguration());
    }

    @Bean
    DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

        factory.setConnectionFactory(this.connectionFactory);
        factory.setDestinationResolver(new DynamicDestinationResolver());
        factory.setConcurrency(concurrency);
        factory.setReceiveTimeout(waitTimeSeconds);
        factory.setMaxMessagesPerTask(numberOfMessagesToReceive);
        factory.setSessionAcknowledgeMode(Session.DUPS_OK_ACKNOWLEDGE);
        return factory;
    }

    @Bean
    JmsTemplate defaultJmsTemplate() {
        return new JmsTemplate(this.connectionFactory);
    }
}