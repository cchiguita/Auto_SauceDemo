package co.com.servicio.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmPage {

    public static final Target CONFIRMATION_MESSAGE = Target.the("mensaje de confirmación").located(By.className("complete-header"));



}
