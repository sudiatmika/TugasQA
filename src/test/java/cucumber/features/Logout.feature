Feature: Logout

  Background:
    Given I am on saucedemo login page
    When  I have enter username and password
    Then I click on the login button

    Scenario: Logout application
      Given I am in Products item
      Then Click button burger
      Then Show side bar
      Then Click Logout menu
      Then Redirect to login page