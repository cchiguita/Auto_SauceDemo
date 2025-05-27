package co.com.servicio.certificacion.tasks;

import co.com.servicio.certificacion.userinterfaces.LoginPage;
import co.com.servicio.certificacion.utils.ExcelReader;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Login withCredentials(String username, String password){
        return Tasks.instrumented(Login.class, username, password);
    }
    public static Login fromExcel(int filaIndex) {
        List<Map<String, String>> datos = ExcelReader.leerDatos("src/test/resources/data/datosCompra.xlsx", "Hoja1");
        Map<String, String> fila = datos.get(filaIndex);
        return Tasks.instrumented(Login.class,
                fila.get("username"),
                fila.get("password")
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginPage.USERNAME),
                Enter.theValue(password).into(LoginPage.PASSWORD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    };

}
