Feature: AddCart

  Background:
    Given I am on saucedemo login page
    When  I have enter username and password
    Then I click on the login button

  Scenario Outline: Add item to cart
    Given I am in Products page
    Then  I select picture product <product_id>
    Then user add <product_name> in cart
    Then <item_count> product added to cart
    Then click back to product
    Examples:
      | product_id | product_name             | item_count |
      | 1          | Sauce Labs Bolt T-Shirt  | 1          |
      | 5          | Sauce Labs Fleece Jacket | 1          |
