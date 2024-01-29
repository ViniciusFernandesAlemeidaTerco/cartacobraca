package br.com.avaliacao.itau.core.utils;

import br.com.avaliacao.itau.core.domain.dto.callbackcarta.CallBackAtualizaCobrancaDTO;
import br.com.avaliacao.itau.core.domain.dto.callbackcarta.CallBackCartaCobrancaDTO;
import br.com.avaliacao.itau.core.domain.dto.cartacobranca.CartaCobrancaDTO;
import br.com.avaliacao.itau.core.domain.dto.dadoscarta.DadosClienteDTO;
import br.com.avaliacao.itau.core.domain.dto.dadoscarta.DadosContratacaoProdutoDTO;
import br.com.avaliacao.itau.core.domain.dto.dadoscarta.DadosEnderecoClienteDTO;
import br.com.avaliacao.itau.core.domain.dto.dadoscarta.DadosProdutoCobrancaDTO;
import br.com.avaliacao.itau.core.domain.enums.CanalCompraEnum;
import br.com.avaliacao.itau.core.domain.mapper.CallBackAtualizaCobrancaMapper;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UtilTeste {


    public static CartaCobrancaDTO criarCartaCobranca() {
        return CartaCobrancaDTO.builder()
                .idCartaCobranca(1)
                .dadosClienteDTO(criarDadosCliente())
                .dadosEnderecoClienteDTO(criarDadosEnderecoCliente())
                .dadosProdutoCobrancaDTO(criarDadosProdutoCobranca())
                .dadosContratacaoProdutoDTO(criarDadosContratacaoProduto())
                .build();
    }

    public static DadosClienteDTO criarDadosCliente() {
        return DadosClienteDTO.builder()
                .idCLiente(1)
                .nomeCLiente("Nome do Cliente")
                .cpfCliente("CPF do Cliente")
                .rgCliente("RG do Cliente")
                .build();
    }

    public static DadosEnderecoClienteDTO criarDadosEnderecoCliente() {
        return DadosEnderecoClienteDTO.builder()
                .logradouro("Logradouro do Endereço do Cliente")
                .numeroEndereco(1)
                .complementoEndereco("Complemento Endereco do Cliente")
                .pontoReferenciaEndereco("Ponto de Referência do Endereço do Cliente")
                .cidadeEndereco("Cidade do Endereço do Cliente")
                .estadoEndereco("Estado do Endereço do Cliente")
                .cepEndereco(12300984)
                .outrosEndereco("Outros do Endereço do Cliente")
                .build();
    }

    public static DadosProdutoCobrancaDTO criarDadosProdutoCobranca() {
        return DadosProdutoCobrancaDTO.builder()
                .idProtudo(1)
                .nomeProduto("Nome do Produto")
                .descricaoProduto("Descrição do Produto")
                .build();
    }

    public static DadosContratacaoProdutoDTO criarDadosContratacaoProduto() {
        return DadosContratacaoProdutoDTO.builder()
                .nomeProduto("Nome do Produto")
                .dataAquisicaoProduto(LocalDateTime.of(2023,01,26,23,59,59))
                .canalCompraEnum(CanalCompraEnum.AGENCIA)
                .valorCobrancaProduto(new BigDecimal(10))
                .build();
    }

    public static ResponseEntity<CallBackCartaCobrancaDTO> criarCallBackCartaCobrancaDTOResponseEntity() {
        return ResponseEntity.ok(criarCallBackCartaCobrancaDTO());
    }

    public static CallBackCartaCobrancaDTO criarCallBackCartaCobrancaDTO(){
        return CallBackCartaCobrancaDTO.builder()
                .idCallBack(1)
                .status("Carta Processada com Sucesso.")
                .build();
    }

    public static CallBackAtualizaCobrancaDTO criarCallBackAtualizaCobranca(){
        return CallBackAtualizaCobrancaMapper.convertAtualizaCartaCobrancaDTO(criarCartaCobranca(),criarCallBackCartaCobrancaDTO());
    }

}