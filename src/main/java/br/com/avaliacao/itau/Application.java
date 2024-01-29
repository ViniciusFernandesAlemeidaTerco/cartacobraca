package br.com.avaliacao.itau;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.jms.annotation.EnableJms;

@EnableFeignClients
@SpringBootApplication
@EnableJms
@OpenAPIDefinition(info = @Info(title = "Gerar Carta Cobrança", version = "1", description = "API para envio de Carta de Cobrança"))
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
