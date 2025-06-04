package co.com.servicio.certificacion.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Flujo_compraexitosa.feature",
        glue = "co.com.servicio.certificacion.stepdefinitions",
        tags = "@test",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunSauceDemo {
}

