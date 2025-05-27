package co.com.servicio.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage {

    public static final Target PRODUCT_LIST = Target.the("lista de productos").located(By.className("inventory_list"));
    public static final Target ADD_TO_CART_BUTTONS = Target.the("botones agregr al carrito").locatedBy("//button[contains(@id,'add-to-cart')]");
    public static final Target CART_ICON = Target.the("ícono del carrito").located(By.className("shopping_cart_link"));

}
