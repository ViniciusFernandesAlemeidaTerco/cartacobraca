package br.com.avaliacao.itau.core.domain.dto.dadoscarta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosClienteDTO {

    private int idCLiente;
    private String nomeCLiente;
    private String cpfCliente;
    private String rgCliente;


}
