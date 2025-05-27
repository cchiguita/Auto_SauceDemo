package co.com.servicio.certificacion.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Flujo_compraexitosa.feature",
        glue = "co.com.servicio.certificacion.stepdefinitions",
        tags = "@test",
        publish = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE

)

public class RunSauceDemo {
}
