package co.com.servicio.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutOverviewPage {

    public static final Target FINISH_BUTTON = Target.the("boton finalizar compra").located(By.id("finish"));
}
