package com.eliath.steps;

import com.eliath.page.ProductPage;
import org.openqa.selenium.WebElement;

public class ProductSteps extends BaseSteps {

    public void addAmountToCart(String quantity) {
        typeNumber(ProductPage.quantityInput, quantity);
        click(ProductPage.addToCartButton);
    }

    public void validateConfirmationMessage() {
        WebElement modalTitle = getElement(ProductPage.modalTitle);
        String titleText = modalTitle.getText().trim();
        if (!titleText.contains("Producto añadido correctamente a su carrito de compra")) {
            throw new AssertionError("El popup no muestra la confirmación");
        }
    }

    public void completePurchase() {
        click(ProductPage.completePurchaseButton);
    }

    public void validateTotalAmount() {
        WebElement modalPrice = getElement(ProductPage.modalPrice);
        WebElement modalQuantity = getElement(ProductPage.modalQuantity);
        WebElement modalTotalAmount = getElement(ProductPage.modalTotalAmount);
        WebElement modalTaxes = getElement(ProductPage.modalTaxes);
        validateTotalAmount(modalPrice.getText(), modalQuantity.getText(), modalTotalAmount.getText(), modalTaxes.getText());
    }

}
