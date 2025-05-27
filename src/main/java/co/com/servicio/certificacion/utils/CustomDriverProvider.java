package co.com.servicio.certificacion.utils;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;

public class CustomDriverProvider implements DriverSource {
    @Override
    public WebDriver newDriver() {
        return WebDriverFactory.iniciarChrome();
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
