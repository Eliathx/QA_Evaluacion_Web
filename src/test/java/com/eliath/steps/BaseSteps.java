package com.eliath.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.eliath.core.DriverManager.getDriver;

public class BaseSteps {

    protected WebDriver driver;
    protected WebDriverWait wait; // esperas explicitas

    public BaseSteps() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    // Los inputs type="number" no borran el valor
    // por defecto con clear() así que debo hacer back_space
    protected void typeNumber(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        element.sendKeys(text);
    }

    protected WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void validateTotalAmount(String priceText, String quantityText, String totalAmountText, String taxesText) {

        int quantity = Integer.parseInt(quantityText.trim());

        int taxesCents = (int) (Double.parseDouble(taxesText.replace("S/", "").trim()) * 100);
        int priceCents = (int) (Double.parseDouble(priceText.replace("S/", "").trim()) * 100);
        int totalAmountCents = (int) (Double.parseDouble(totalAmountText.replace("S/", "").trim()) * 100);

        int expectedTotalCents = priceCents * quantity + taxesCents;

        System.out.println("Cantidad: " + quantityText);
        System.out.println("Precio: " + priceText);
        System.out.println("Impuestos: " + taxesText);
        System.out.println("Total mostrado: " + totalAmountText);
        System.out.println("Total calculado: S/ " + expectedTotalCents / 100.0);

        if (expectedTotalCents != totalAmountCents) {
            throw new AssertionError(
                    "Total incorrecto. Se calculó " + (expectedTotalCents / 100.0) +
                            " pero se mostró " + (totalAmountCents / 100.0)
            );
        }
    }
}
