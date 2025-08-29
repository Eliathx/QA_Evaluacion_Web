package com.eliath.page;

import org.openqa.selenium.By;


public class LoginPage {

    public static By emailInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");

    public static By errorMessage = By.cssSelector(".alert");
}