package br.com.avaliacao.itau.core.domain.dto.dadoscarta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosEnderecoClienteDTO {

    private String logradouro;
    private int numeroEndereco;
    private String complementoEndereco;
    private String pontoReferenciaEndereco;
    private String cidadeEndereco;
    private String estadoEndereco;
    private int cepEndereco;
    private String outrosEndereco;

}
