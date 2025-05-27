package co.com.servicio.certificacion.tasks;

import co.com.servicio.certificacion.userinterfaces.CheckoutOverviewPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ConfirmOrder implements Task {

    public static ConfirmOrder now(){
        return Tasks.instrumented(ConfirmOrder.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckoutOverviewPage.FINISH_BUTTON)
        );

    }
}
