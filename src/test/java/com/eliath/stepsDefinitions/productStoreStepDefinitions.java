package com.eliath.stepsDefinitions;

import com.eliath.steps.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.eliath.core.DriverManager.getDriver;
import static com.eliath.core.DriverManager.screenShot;

public class productStoreStepDefinitions {

    private WebDriver driver;
    LoginSteps loginSteps = new LoginSteps();
    CategorySteps categorySteps = new CategorySteps();
    ProductsListSteps productsListSteps = new ProductsListSteps();
    ProductSteps productSteps = new ProductSteps();
    CartSteps cartSteps = new CartSteps();

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioUsuarioYClaveClave(String usuario, String clave) {
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion");
        loginSteps.login(usuario, clave);
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaCategoriaYSubcategoriaSubcategoria(String categoria, String subcategoria) {
        categorySteps.selectCategory(categoria);
        categorySteps.selectSubcategory(subcategoria);

        screenShot();
    }

    @Y("agrego {string} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(String cantidad) {
        productsListSteps.goToFirstProductPage(); //primero hay que seleccionar el primer prod
        productSteps.addAmountToCart(cantidad);
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        productSteps.validateConfirmationMessage();
        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        productSteps.validateTotalAmount();
        screenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        productSteps.completePurchase();
        screenShot();

    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        cartSteps.validatePageTitle();
        screenShot();
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        cartSteps.validateTotalAmount();
        screenShot();
    }

}
