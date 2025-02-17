package br.com.avaliacao.itau.outbound.sqs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class OutboundSqsConfiguration {

    @Value("${aws.region}")
    private String awsRegion;

    @Bean("sqsClientOutbound")
    SqsClient sqsAdapterOutboundClient() {

        return SqsClient.builder()
                .region(Region.of(awsRegion))
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }
}
