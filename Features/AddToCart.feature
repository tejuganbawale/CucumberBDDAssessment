Feature: Add Products to cart Test

   @tag2
  Scenario: Verify adding products to the shopping cart   
    Given I log into Sauce Labs website successfully
    And I land on products listing page
    When I add following products to cart
    | Sauce Labs Backpack |
    | Test.allTheThings() T-Shirt (Red) |
    Then I validate desired products are present in cart
 
