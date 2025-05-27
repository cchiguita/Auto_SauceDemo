package co.com.servicio.certificacion.tasks;

import co.com.servicio.certificacion.userinterfaces.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class GoToCart implements Task {

    public static GoToCart now(){
        return Tasks.instrumented(GoToCart.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductPage.CART_ICON)
        );

    }
}
