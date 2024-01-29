package br.com.avaliacao.itau.integration.conf;

import br.com.avaliacao.itau.Application;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@CucumberContextConfiguration
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(properties = "server.port=9090")
@ActiveProfiles(profiles = { "integration" }, resolver = ProfilesResolver.class)
public class CucumberTestContextConfiguration {

}