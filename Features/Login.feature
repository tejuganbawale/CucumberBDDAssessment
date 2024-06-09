Feature: Sauce Lab Login

  Scenario: Login into saucedemo website with valid credentials
    Given I go to on saucedemo website
    When Valid username and password are entered
    And Login button is clicked
    Then I land on products listing page

 Scenario: Login into saucedemo website with invalid credentials
    Given I go to on saucedemo website
    When Invalid username and password are entered
    And Login button is clicked
    Then Error displayed for failed login
