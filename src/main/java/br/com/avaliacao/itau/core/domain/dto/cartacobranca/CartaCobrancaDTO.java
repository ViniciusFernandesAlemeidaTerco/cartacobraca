package br.com.avaliacao.itau.core.domain.dto.cartacobranca;

import br.com.avaliacao.itau.core.domain.dto.dadoscarta.DadosClienteDTO;
import br.com.avaliacao.itau.core.domain.dto.dadoscarta.DadosContratacaoProdutoDTO;
import br.com.avaliacao.itau.core.domain.dto.dadoscarta.DadosEnderecoClienteDTO;
import br.com.avaliacao.itau.core.domain.dto.dadoscarta.DadosProdutoCobrancaDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaCobrancaDTO implements ComponenteCartaCobranca {

    private int idCartaCobranca;
    private DadosClienteDTO dadosClienteDTO;
    private DadosEnderecoClienteDTO dadosEnderecoClienteDTO;
    private DadosProdutoCobrancaDTO dadosProdutoCobrancaDTO;
    private DadosContratacaoProdutoDTO dadosContratacaoProdutoDTO;

    @Override
    public void etiquetaCobranca() {
        StringBuilder dadosEtiqueta = new StringBuilder();
        dadosEtiqueta
                .append("Rua:").append(dadosEnderecoClienteDTO.getLogradouro())
                .append("Número:").append(dadosEnderecoClienteDTO.getNumeroEndereco())
                .append("Complemento:").append(dadosEnderecoClienteDTO.getComplementoEndereco())
                .append("Cidade:").append(dadosEnderecoClienteDTO.getCidadeEndereco())
                .append("Estado:").append(dadosEnderecoClienteDTO.getEstadoEndereco())
                .append("CEP:").append(dadosEnderecoClienteDTO.getCepEndereco())
                .append("Outros:").append(dadosEnderecoClienteDTO.getOutrosEndereco());
    }

    @Override
    public void dadosCobraca() {

    }
}
