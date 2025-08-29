package com.eliath.page;

import org.openqa.selenium.By;

public class ProductPage {
    public static By addToCartButton = By.cssSelector("button.btn.btn-primary.add-to-cart");
    public static By quantityInput = By.id("quantity_wanted");

    public static By modalTitle = By.id("myModalLabel");
    public static By modalPrice = By.cssSelector("p.product-price");
    public static By modalQuantity = By.cssSelector("span.product-quantity > strong:nth-child(1)");
    public static By modalTotalAmount = By.cssSelector(".product-total > span:nth-child(2)");
    public static By modalTaxes = By.cssSelector("span.value:nth-child(1)");


    public static By completePurchaseButton = By.cssSelector(".cart-content-btn > a:nth-child(2)");
}