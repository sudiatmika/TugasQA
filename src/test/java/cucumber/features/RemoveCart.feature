Feature: RemoveCart

  Background:
    Given I am on saucedemo login page
    When  I have enter username and password
    Then I click on the login button

    Scenario: RemoveCart in your cart page
      Given Add product sauce lab bike light in cart
      Then Click Cart Icon
      Then Show your cart page
      Then Click remove button sauce lab bike light
