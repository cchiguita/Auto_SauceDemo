package co.com.servicio.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USERNAME = Target.the("usuario").located(By.id("user-name"));
    public static final Target PASSWORD = Target.the("contraseña").located(By.id("password"));
    public static final Target LOGIN_BUTTON = Target.the("login_button").located(By.id("login-button"));

}
