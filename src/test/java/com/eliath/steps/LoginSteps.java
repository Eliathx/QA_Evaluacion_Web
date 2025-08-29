package com.eliath.steps;

import com.eliath.page.LoginPage;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

import static com.eliath.core.DriverManager.screenShot;

public class LoginSteps extends BaseSteps {

    public void login(String email, String password) {
        type(LoginPage.emailInput, email);
        type(LoginPage.passInput, password);
        click(LoginPage.loginButton);

        screenShot();

        List<WebElement> errorElements = driver.findElements(LoginPage.errorMessage);

        // si existe un mensaje de error y es Error de autenticación, detener el test
        if (!errorElements.isEmpty()) {
            String errorText = errorElements.get(0).getText();
            if (Objects.equals(errorText, "Error de autenticación.")) {
                throw new AssertionError("Credenciales incorrectas. Error de autenticación.");
            }
        }

    }

}
