package br.com.avaliacao.itau.core.utils;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JsonUtilTest {

//	@Test
//	void testJsonUtilToJsonNotNull() {
//		EnvioParceiroTransacaoAprovadaDTO obj = UtilTeste.criarEnvioParceiroTransacaoAprovadaDTO();
//		String value = JsonUtil.toJson(obj);
//		assertNotNull(value);
//	}
//
//	@Test
//	void testJsonDeserialize() {
//		EnvioParceiroTransacaoAprovadaDTO obj = UtilTeste.criarEnvioParceiroTransacaoAprovadaDTO();
//		String value = JsonUtil.toJson(obj);
//		EnvioParceiroTransacaoAprovadaDTO obj2 = JsonUtil.fromJson(value, EnvioParceiroTransacaoAprovadaDTO.class);
//		assertNotNull(obj2);
//	}
//
//	@Test
//	void testJsonUtilToJsonNotNullDateFormat() {
//		EnvioParceiroTransacaoAprovadaDTO obj = UtilTeste.criarEnvioParceiroTransacaoAprovadaDTO();
//		String value = JsonUtil.toJson(obj, "yyyy-MM-dd'T'HH:mm:ss");
//		assertNotNull(value);
//
//	}
//
//	@Test
//	void testJsonUtilFromJsonNotNull() {
//		EnvioParceiroTransacaoAprovadaDTO value = JsonUtil.fromJson("{\"codIdentificador\":\"10\"}",
//				EnvioParceiroTransacaoAprovadaDTO.class);
//		assertNotNull(value);
//
//	}
//
//	@Test
//	void testJsonUtilFromJsonNotNullDateFormat() {
//		EnvioParceiroTransacaoAprovadaDTO value = JsonUtil.fromJson("{\"codIdentificador\":\"10\"}",
//				EnvioParceiroTransacaoAprovadaDTO.class, "yyyy-MM-dd'T'HH:mm:ss");
//		assertNotNull(value);
//
//	}
//
//	@Test
//	void testEnvioTransacaoParceiroGetIdentificacaoTransacao() {
//		EnvioTransacaoParceiro obj = UtilTeste.criarEnvioTransacaoParceiro();
//		obj.getIdentificacaoTransacao();
//		assertNotNull(obj);
//
//	}
//
//	@Test
//	void testEnvioTransacaoParceiroJson() {
//		EnvioTransacaoParceiro obj = UtilTeste.criarEnvioTransacaoParceiro();
//		obj.toJson();
//		assertNotNull(obj);
//
//
//	}
//
//	@ParameterizedTest
//	@ValueSource(strings = {
//			"{\"billing\":\"2004826\",\"categoria\":\"DOIS_EIXOS_RODAGEM_SIMPLES\",\"codIdentificador\":\"1113132394\",\"codPlaca\":\"QOM0225\",\"contexto\":\"ARTESP\",\"dataHoraPassagem\":\"2023-06-19T11:00:48.000Z\",\"dataHoraRecebimento\":\"2023-06-22T16:50:24.000Z\",\"descricaoLocal\":\"ROD REGIS BITTENCOURT, 100.0, SUL, MACEIÓ - SP\",\"idTransacao\":\"f1744c1b-c4e7-4939-8649-998822dc9607\",\"motivoTransacao\":\"PASSAGEM_FORA_SLA\",\"nomeEstabelecimento\":\"5\",\"tipoTransacao\":\"PEDAGIO\",\"valorTransacao\":5.12,\"passagemAutomatica\":false,\"estorno\":false,\"idCliente\":\"1697889\"}"
//			,"{\"billing\":\"2004826\",\"categoria\":\"DOIS_EIXOS_RODAGEM_SIMPLES\",\"codIdentificador\":\"1113132394\",\"codPlaca\":\"QOM0225\",\"contexto\":\"ARTESP\",\"dataHoraPassagem\":\"\",\"dataHoraRecebimento\":\"2023-06-22T16:50:24.000Z\",\"descricaoLocal\":\"ROD REGIS BITTENCOURT, 100.0, SUL, MACEIÓ - SP\",\"idTransacao\":\"f1744c1b-c4e7-4939-8649-998822dc9607\",\"motivoTransacao\":\"PASSAGEM_FORA_SLA\",\"nomeEstabelecimento\":\"5\",\"tipoTransacao\":\"PEDAGIO\",\"valorTransacao\":5.12,\"passagemAutomatica\":false,\"estorno\":false,\"idCliente\":\"1697889\"}"
//			,"{\"billing\":\"2004826\",\"categoria\":\"DOIS_EIXOS_RODAGEM_SIMPLES\",\"codIdentificador\":\"1113132394\",\"codPlaca\":\"QOM0225\",\"contexto\":\"ARTESP\",\"dataHoraPassagem\":null,\"dataHoraRecebimento\":\"2023-06-22T16:50:24.000Z\",\"descricaoLocal\":\"ROD REGIS BITTENCOURT, 100.0, SUL, MACEIÓ - SP\",\"idTransacao\":\"f1744c1b-c4e7-4939-8649-998822dc9607\",\"motivoTransacao\":\"PASSAGEM_FORA_SLA\",\"nomeEstabelecimento\":\"5\",\"tipoTransacao\":\"PEDAGIO\",\"valorTransacao\":5.12,\"passagemAutomatica\":false,\"estorno\":false,\"idCliente\":\"1697889\"}"
//			,"{\"billing\":\"2004826\",\"categoria\":\"DOIS_EIXOS_RODAGEM_SIMPLES\",\"codIdentificador\":\"1113132394\",\"codPlaca\":\"QOM0225\",\"contexto\":\"ARTESP\",\"dataHoraRecebimento\":\"2023-06-22T16:50:24.000Z\",\"descricaoLocal\":\"ROD REGIS BITTENCOURT, 100.0, SUL, MACEIÓ - SP\",\"idTransacao\":\"f1744c1b-c4e7-4939-8649-998822dc9607\",\"motivoTransacao\":\"PASSAGEM_FORA_SLA\",\"nomeEstabelecimento\":\"5\",\"tipoTransacao\":\"PEDAGIO\",\"valorTransacao\":5.12,\"passagemAutomatica\":false,\"estorno\":false,\"idCliente\":\"1697889\"}"
//	})
//	void testRecebimentoReal(String json) {
//
//		EnvioParceiroTransacaoAprovadaDTO valor = JsonUtil.fromJson(json, EnvioParceiroTransacaoAprovadaDTO.class);
//		assertNotNull(valor);
//	}

}
