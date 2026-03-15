package com.umair.framework.pages;

import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.By;

/**
 * Page Object for the SauceDemo login page.
 */
@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends BasePage {

    private static final By USERNAME_FIELD  = By.id("user-name");
    private static final By PASSWORD_FIELD  = By.id("password");
    private static final By LOGIN_BUTTON    = By.id("login-button");
    private static final By ERROR_MESSAGE   = By.cssSelector("[data-test='error']");

    public void enterUsername(String username) {
        waitAndType(USERNAME_FIELD, username);
    }

    public void enterPassword(String password) {
        waitAndType(PASSWORD_FIELD, password);
    }

    public void clickLogin() {
        waitAndClick(LOGIN_BUTTON);
    }

    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return waitAndGetText(ERROR_MESSAGE);
    }

    public boolean isErrorDisplayed() {
        return isElementDisplayed(ERROR_MESSAGE);
    }
}
