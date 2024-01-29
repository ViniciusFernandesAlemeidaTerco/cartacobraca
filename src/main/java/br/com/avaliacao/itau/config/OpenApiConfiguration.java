package br.com.avaliacao.itau.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class OpenApiConfiguration implements WebMvcConfigurer {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI().components(new Components()).info(new Info()
                        .title("API - Gerar Carta Cobrança")
                        .description("API para envio de carta de cobrança")
                        .version("1.0.0")
                        .contact(new Contact().name("Squad Avaliação")));
    }
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
