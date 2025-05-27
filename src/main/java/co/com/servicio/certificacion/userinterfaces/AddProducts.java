package co.com.servicio.certificacion.userinterfaces;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class AddProducts implements Task {

    private final int cantidad;

    public AddProducts(int cantidad) {
        this.cantidad = cantidad;
    }

    public static AddProducts toCart(int cantidad){
        return Tasks.instrumented(AddProducts.class, cantidad);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> botones = ProductPage.ADD_TO_CART_BUTTONS.resolveAllFor(actor);

        for (int i = 0; i<cantidad && i < botones.size(); i++){
           botones.get(i).click();

        }

    }
}
