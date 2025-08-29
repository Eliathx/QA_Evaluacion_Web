package com.eliath.steps;

import com.eliath.page.CartPage;
import org.openqa.selenium.WebElement;

public class CartSteps extends BaseSteps {

    public void validatePageTitle() {
        String title = driver.getTitle();
        String expectedTitle = "Carrito";

        if (!title.equals(expectedTitle)) {
            throw new AssertionError(
                    "Título de página incorrecto. Se esperaba: "
                            + expectedTitle + " pero se obtuvo: " + title
            );
        }
    }

    public void validateTotalAmount() {
        WebElement price = getElement(CartPage.price);
        WebElement quantity = getElement(CartPage.quantityInput);
        WebElement totalAmount = getElement(CartPage.totalAmount);
        WebElement taxes = getElement(CartPage.taxes);

        validateTotalAmount(price.getText(), quantity.getAttribute("value"), totalAmount.getText(), taxes.getText());

    }
}
