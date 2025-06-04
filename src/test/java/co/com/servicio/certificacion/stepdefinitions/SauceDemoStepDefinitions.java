package co.com.servicio.certificacion.stepdefinitions;

import co.com.servicio.certificacion.questions.TheConfirmationMessage;
import co.com.servicio.certificacion.tasks.*;
import co.com.servicio.certificacion.userinterfaces.AddProducts;
import co.com.servicio.certificacion.utils.WebDriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class SauceDemoStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Cristian").can(BrowseTheWeb.with(driver));
    }

    @Given("el usuario accede al sitio web")
    public void elUsuarioAccedeAlSitioWeb() {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                Open.url("https://www.saucedemo.com")
        );
    }
    @When("el usuario inicia sesión usando los datos del Excel")
    public void elUsuarioIniciaSesionUsandoLosDatosDelExcel() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.fromExcel(1)
        );
    }
    @And("agrega {string}  al carrito")
    public void agregaAlCarrito(String cantidadProductos) {
        int cantidad = Integer.parseInt(cantidadProductos);
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProducts.toCart(cantidad));

    }
    @And("ir al carrito de compras")
    public void irAlCarritoDeCompras() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToCart.now()
        );
    }
    @And("proceed to checkout")
    public void procederAlCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProceedToCheckout.now()
        );
    }
    @And("Completa el formulario de compra")
    public void completaElFormularioDeCompra() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletePurchaseForm.fromExcel("src/test/resources/data/datosCompra.xlsx", "Hoja1")
        );
    }

    @And("confirma la orden")
    public void confirmaLaOrden() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ConfirmOrder.now()
        );
    }
    @Then("valida el  mensaje de {string}")
    public void validaElMensajeDeConfirmacion(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheConfirmationMessage.text(), equalTo(mensajeEsperado))
        );
    }
}
