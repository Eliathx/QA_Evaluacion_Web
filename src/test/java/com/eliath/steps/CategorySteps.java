package com.eliath.steps;

import com.eliath.page.CategoryPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategorySteps extends BaseSteps {

    public void selectCategory(String categoryName) {
        List<WebElement> elements = driver.findElements(CategoryPage.categories);
        boolean found = false;

        for (WebElement el : elements) {
            if (el.getText().trim().equalsIgnoreCase(categoryName)) {
                el.click();
                found = true;
                break;
            }
        }

        if (!found) {
            throw new AssertionError("Categoría " + categoryName + " no encontrada");
        }
    }

    public void selectSubcategory(String subcategoryName) {
        List<WebElement> elements = driver.findElements(CategoryPage.subcategories);
        boolean found = false;

        for (WebElement el : elements) {
            if (el.getText().trim().equalsIgnoreCase(subcategoryName)) {
                el.click();
                found = true;
                break;
            }
        }

        if (!found) {
            throw new AssertionError("Subcategoria " + subcategoryName + " no encontrada");
        }
    }


}
