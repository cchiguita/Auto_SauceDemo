package co.com.servicio.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {

    public static final Target CART_ITEMS = Target.the("productos en el carrito").located(By.className("cart_item"));
    public static final Target CHECKOUT_BUTTON = Target.the("boton checkout").located(By.id("checkout"));
}
