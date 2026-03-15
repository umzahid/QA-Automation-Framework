Feature: SauceDemo E2E Login and Shopping

  Background:
    Given the user is on the login page

  @smoke @login
  Scenario Outline: Successful login with valid credentials
    When the user logs in with username "<username>" and password "<password>"
    Then the user should see the inventory page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @negative @login
  Scenario: Failed login with invalid credentials
    When the user logs in with username "invalid_user" and password "wrong_pass"
    Then the user should see an error message containing "Username and password do not match"

  @smoke @cart
  Scenario: Add item to cart and verify cart count
    Given the user is logged in as "standard_user" with password "secret_sauce"
    When the user adds the first product to the cart
    Then the cart badge should show "1"

  @regression @logout
  Scenario: User can log out successfully
    Given the user is logged in as "standard_user" with password "secret_sauce"
    When the user logs out
    Then the user should be redirected to the login page
