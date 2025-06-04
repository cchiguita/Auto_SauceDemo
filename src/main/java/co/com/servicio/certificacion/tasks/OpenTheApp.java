package co.com.servicio.certificacion.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenTheApp {


    public static Task onLoginPage() {
        return Task.where("{0} abre la página principal",
                Open.url("https://www.saucedemo.com")
        );
    }
}