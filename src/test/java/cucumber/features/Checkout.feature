Feature: Checkout Product

  Background:
    Given I am on saucedemo login page
    When  I have enter username and password
    Then I click on the login button

    @CheckoutPositive
    Scenario: Checkout product and Pay
      Given Add product sauce lab bike light in cart
      Then Click Cart Icon
      Then Show your cart page
      Then Click button checkout
      Then Insert first name
      And Insert last name
      And  Insert postal code
      Then Click button continue
      Then Show checkout page
      Then Pay checkout product
      Then Success checkout

  @CheckoutNegative
  Scenario: Checkout product without insert form personal data
    Given Add product sauce lab bike light in cart
    Then Click Cart Icon
    Then Show your cart page
    Then Click button checkout
    Then Click button continue
    Then error display checkout