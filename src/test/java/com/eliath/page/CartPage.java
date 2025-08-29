package com.eliath.page;

import org.openqa.selenium.By;

public class CartPage {

    public static By quantityInput = By.cssSelector(".js-cart-line-product-quantity");
    public static By price = By.cssSelector("span.price");
    public static By totalAmount = By.cssSelector("div.cart-summary-line:nth-child(2) > span:nth-child(2)");
    public static By taxes = By.cssSelector("span.sub:nth-child(2)");
}