package com.umair.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Page Object for the SauceDemo inventory (products) page.
 */
public class InventoryPage extends BasePage {

    private static final By PAGE_TITLE      = By.cssSelector(".title");
    private static final By PRODUCT_NAMES   = By.cssSelector(".inventory_item_name");
    private static final By PRODUCT_PRICES  = By.cssSelector(".inventory_item_price");
    private static final By ADD_TO_CART_BTN = By.cssSelector("button[id^='add-to-cart']");
    private static final By CART_BADGE      = By.cssSelector(".shopping_cart_badge");
    private static final By CART_ICON       = By.cssSelector(".shopping_cart_link");
    private static final By SORT_DROPDOWN   = By.cssSelector("select.product_sort_container");
    private static final By BURGER_MENU     = By.id("react-burger-menu-btn");
    private static final By LOGOUT_LINK     = By.id("logout_sidebar_link");

    public boolean isLoaded() {
        return isElementDisplayed(PAGE_TITLE);
    }

    public String getPageTitle() {
        return waitAndGetText(PAGE_TITLE);
    }

    public List<String> getProductNames() {
        return getDriver().findElements(PRODUCT_NAMES)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void addFirstItemToCart() {
        waitAndClick(ADD_TO_CART_BTN);
    }

    public int getCartCount() {
        try {
            return Integer.parseInt(waitAndGetText(CART_BADGE));
        } catch (Exception e) {
            return 0;
        }
    }

    public void goToCart() {
        waitAndClick(CART_ICON);
    }

    public void logout() {
        waitAndClick(BURGER_MENU);
        waitAndClick(LOGOUT_LINK);
    }
}
