package co.com.servicio.certificacion.tasks;

import co.com.servicio.certificacion.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ProceedToCheckout implements Task {

    public static ProceedToCheckout now(){
        return Tasks.instrumented(ProceedToCheckout.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartPage.CHECKOUT_BUTTON)
        );

    }
}
