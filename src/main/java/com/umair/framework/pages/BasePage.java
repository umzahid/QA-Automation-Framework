package com.umair.framework.pages;

import com.umair.framework.config.ConfigManager;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Base class for all Page Objects.
 * Provides common helpers: waitFor, click, type, getText, isDisplayed.
 */
public abstract class BasePage extends PageObject {

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(),
                Duration.ofSeconds(ConfigManager.getInt("explicit.wait")));
    }

    protected void waitAndClick(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void waitAndType(By locator, String text) {
        WebElement el = getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(text);
    }

    protected String waitAndGetText(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText().trim();
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    protected void navigateTo(String path) {
        String baseUrl = ConfigManager.get("base.url");
        getDriver().get(baseUrl + path);
    }
}
