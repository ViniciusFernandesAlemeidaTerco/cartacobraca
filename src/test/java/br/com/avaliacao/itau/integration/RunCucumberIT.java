package br.com.avaliacao.itau.integration;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("br/com/veloe/triar/transacao/parceiro/integration")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "br.com.veloe.triar.transacao.parceiro.integration")
public class RunCucumberIT {}

