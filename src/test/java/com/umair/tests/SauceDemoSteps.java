package com.umair.tests;

import com.umair.framework.pages.InventoryPage;
import com.umair.framework.pages.LoginPage;
import io.cucumber.java.en.*;
import net.serenitybdd.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;

/**
 * Cucumber step definitions for SauceDemo E2E scenarios.
 * Uses Serenity page injection via @Steps or direct instantiation.
 */
public class SauceDemoSteps extends PageObject {

    private final LoginPage    loginPage    = new LoginPage();
    private final InventoryPage inventoryPage = new InventoryPage();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPage.openAt("https://www.saucedemo.com/");
    }

    @When("the user logs in with username {string} and password {string}")
    public void theUserLogsIn(String username, String password) {
        loginPage.loginAs(username, password);
    }

    @Then("the user should see the inventory page")
    public void theUserShouldSeeInventoryPage() {
        Assertions.assertTrue(inventoryPage.isLoaded(),
                "Expected inventory page to be loaded");
        Assertions.assertEquals("Products", inventoryPage.getPageTitle());
    }

    @Then("the user should see an error message containing {string}")
    public void theUserShouldSeeError(String expectedMessage) {
        Assertions.assertTrue(loginPage.isErrorDisplayed(),
                "Expected error message to be visible");
        Assertions.assertTrue(loginPage.getErrorMessage().contains(expectedMessage),
                "Error message mismatch. Actual: " + loginPage.getErrorMessage());
    }

    @Given("the user is logged in as {string} with password {string}")
    public void theUserIsLoggedIn(String username, String password) {
        loginPage.openAt("https://www.saucedemo.com/");
        loginPage.loginAs(username, password);
        Assertions.assertTrue(inventoryPage.isLoaded(), "Login failed — inventory page not visible");
    }

    @When("the user adds the first product to the cart")
    public void theUserAddsFirstProduct() {
        inventoryPage.addFirstItemToCart();
    }

    @Then("the cart badge should show {string}")
    public void cartBadgeShouldShow(String expectedCount) {
        Assertions.assertEquals(Integer.parseInt(expectedCount), inventoryPage.getCartCount(),
                "Cart count mismatch");
    }

    @When("the user logs out")
    public void theUserLogsOut() {
        inventoryPage.logout();
    }

    @Then("the user should be redirected to the login page")
    public void theUserRedirectedToLogin() {
        Assertions.assertTrue(loginPage.isLoginButtonDisplayed(),
                "Expected login button to be visible after logout");
    }
}
