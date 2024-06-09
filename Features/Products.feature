@tag
Feature: Products Listing Test

  @tag1
  Scenario: Verify that products are listed correctly after login
    Given I log into Sauce Labs website successfully
    And I land on products listing page
    When I verify names of products on products listing page
    Then I validate products names match with expected names

 
    
    