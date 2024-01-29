@cliente
Feature: Transacao Parceiro

  @EnviarCartaCobraca
  Scenario Outline: EnviarCartaCobranca
    When criar um objeto CartaCobrancaDTO
    And enviar o objeto Carta de Cobrança DTO para o parceiro
    Then receber codigo 200

 		