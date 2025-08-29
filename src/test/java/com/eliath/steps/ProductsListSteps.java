package com.eliath.steps;

import com.eliath.page.ProductsListPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsListSteps extends BaseSteps {

    public void goToFirstProductPage() {
        List<WebElement> productsList = wait.until(
                driver -> driver.findElements(ProductsListPage.productItems)
        );
        if (productsList.isEmpty()) {
            throw new RuntimeException("No hay productos en la lista.");
        }

        WebElement firstProduct = productsList.get(0);

        firstProduct.click();

    }

}
