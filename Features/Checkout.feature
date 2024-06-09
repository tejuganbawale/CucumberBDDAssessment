Feature: Checkout Flow Test

  Scenario: Verify adding products till checkout prcoess   
    Given I log into Sauce Labs website successfully
    And I add following products to cart
    | Sauce Labs Backpack |
    | Test.allTheThings() T-Shirt (Red) |
    When I enter following user details in checkout process
    | FirstName | LastName | PostalCode |
    | Josh | Fitzgerald | 1234 |
    And I verify billing details
    Then I confirm the placed order