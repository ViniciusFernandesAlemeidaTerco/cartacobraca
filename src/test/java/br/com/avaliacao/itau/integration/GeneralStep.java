package br.com.avaliacao.itau.integration;

import br.com.avaliacao.itau.core.domain.dto.cartacobranca.CartaCobrancaDTO;
import br.com.avaliacao.itau.core.utils.JsonUtil;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;

import java.time.format.DateTimeFormatter;

public class GeneralStep {

    @Value("${application.context-path}")
    private String basePath;

    @Value("${server.port}")
    private String port;

    @Value("${aws.region}")
    private String awsRegion;

    private Response response;

    private CartaCobrancaDTO cartaCobrancaDTO;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Before
    public void before() {
        RestAssured.baseURI = "http://localhost:" + port + basePath;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        System.out.println(RestAssured.baseURI);
    }


    @When("criar um objeto CartaCobrancaDTO")
    public void criar_um_objeto_carta_cobranca_dto() {
        String payload = "{\n" +
                "  \"idCartaCobranca\": 1,\n" +
                "  \"DadosClienteDTO\": {\n" +
                "    \"idCLiente\": 1,\n" +
                "    \"nomeCLiente\": \"Nome Cliente\",\n" +
                "    \"cpfCliente\": \"CPF Cliente\",\n" +
                "    \"rgCliente\": \"RG Cliente\"\n" +
                "  },\n" +
                "  \"DadosEnderecoClienteDTO\": {\n" +
                "    \"logradouro\": \"Logradouro do Endereço do Cliente\",\n" +
                "    \"numeroEndereco\": 1,\n" +
                "    \"complementoEndereco\": \"Complemento Endereco do Cliente\",\n" +
                "    \"pontoReferenciaEndereco\": \"Ponto de Referência do Endereço do Cliente\",\n" +
                "    \"cidadeEndereco\": \"Cidade do Endereço do Cliente\",\n" +
                "    \"estadoEndereco\": \"Estado do Endereço do Cliente\",\n" +
                "    \"cepEndereco\": 12300984,\n" +
                "    \"outrosEndereco\": \"Outros do Endereço do Cliente\"\n" +
                "  },\n" +
                "  \"DadosProdutoCobrancaDTO\": {\n" +
                "    \"idProtudo\": 1,\n" +
                "    \"nomeProduto\": \"Nome do Produto\",\n" +
                "    \"descricaoProduto\": \"Descrição do Produto\"\n" +
                "  },\n" +
                "  \"DadosContratacaoProdutoDTO\": {\n" +
                "    \"nomeProduto\": \"Nome do Produto\",\n" +
                "    \"dataAquisicaoProduto\": \"2023-07-24T15:50:18.000Z\",\n" +
                "    \"canalCompraEnum\": \"AGENCIA\",\n" +
                "    \"BigDecimal\": \"10.0\"\n" +
                "  }\n" +
                "}";

        cartaCobrancaDTO = JsonUtil.fromJson(payload, CartaCobrancaDTO.class);

    }

    @When("enviar o objeto Carta de Cobrança DTO para o parceiro")
    public void enviar_o_objeto_carta_de_cobraca_dto_para_o_parceiro() {
        String payload = JsonUtil.toJson(cartaCobrancaDTO);
        this.response = RestAssured.given()
                                   .contentType(ContentType.JSON)
                                   .body(payload)
                                   .when()
                                   .post("/testeIntegracaoCartaCobraca");
    }

}