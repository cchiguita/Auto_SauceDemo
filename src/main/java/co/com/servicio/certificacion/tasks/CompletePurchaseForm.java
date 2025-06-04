package co.com.servicio.certificacion.tasks;

import co.com.servicio.certificacion.userinterfaces.CheckoutPage;
import co.com.servicio.certificacion.utils.ExcelReader;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class CompletePurchaseForm implements Task {

    private final String nombre;
    private final String apellido;
    private final String codigoPostal;

    public CompletePurchaseForm(String nombre, String apellido, String codigoPostal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoPostal = codigoPostal;
    }

    public static CompletePurchaseForm with(String nombre, String apellido, String codigoPostal){
        return Tasks.instrumented(CompletePurchaseForm.class, nombre, apellido, codigoPostal);
    }
    public static CompletePurchaseForm fromExcel(String ruta, String hoja) {
        List<Map<String, String>> datos = ExcelReader.leerDatos(ruta, hoja);

        // Selecciona un índice aleatorio entre 0 y datos.size() - 1
        int filaIndex = new Random().nextInt(datos.size());

        Map<String, String> fila = datos.get(filaIndex);
        return Tasks.instrumented(CompletePurchaseForm.class,
                fila.get("nombre"),
                fila.get("apellido"),
                fila.get("codigo_postal")
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre).into(CheckoutPage.FIRST_NAME),
                Enter.theValue(apellido).into(CheckoutPage.LAST_NAME),
                Enter.theValue(codigoPostal).into(CheckoutPage.POSTAL_CODE),
                Click.on(CheckoutPage.CONTINUE_BUTTON)
        );

    }
}
