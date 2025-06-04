package co.com.servicio.certificacion.stepdefinitions;

import co.com.servicio.certificacion.utils.WebDriverFactory;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static final Actor usuario = Actor.named("Cristian");

    @Before
    public void setUp(){
        WebDriver driver = WebDriverFactory.iniciarChrome();
        usuario.can(BrowseTheWeb.with(driver));
    }


}
