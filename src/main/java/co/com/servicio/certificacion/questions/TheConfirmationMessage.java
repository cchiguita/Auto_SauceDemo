package co.com.servicio.certificacion.questions;

import co.com.servicio.certificacion.userinterfaces.ConfirmPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheConfirmationMessage implements Question<String> {

    public static TheConfirmationMessage text(){
        return new TheConfirmationMessage();

    }
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ConfirmPage.CONFIRMATION_MESSAGE).answeredBy(actor);
    }
}
