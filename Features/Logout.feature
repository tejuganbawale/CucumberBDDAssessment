Feature: Sauce Lab Logout

  Scenario: Logout from saucedemo website
    Given I log into Sauce Labs website successfully
    When I open menu list
    And I click on logout option
    Then I go to on saucedemo website