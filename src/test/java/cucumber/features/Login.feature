Feature: Login in to website saucedemo

  Background:
    Given I am on saucedemo login page

  Scenario: Success login with valid credential
    Given I have enter username and password
    Then I click on the login button
    Then I should be logged in successfully

  Scenario: Failed login wih invalid credential
    Given I have enter invalid username and password
    When I click on the login button
    Then Show Error message credential