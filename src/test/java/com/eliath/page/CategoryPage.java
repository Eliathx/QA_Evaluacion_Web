package com.eliath.page;

import org.openqa.selenium.By;

public class CategoryPage {

    public static By categories = By.cssSelector("ul#top-menu li.category > a.dropdown-item");
    public static By subcategories = By.cssSelector(".subcategories-list .subcategory-name");
}