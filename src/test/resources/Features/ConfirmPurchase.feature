Feature: Confirm Purchase

  Scenario Outline: Confirm Purchase resets the form
    Given I am on the product page
    And I fill in valid product details "<deviceType>" "<brand>" "<storage>" "<color>" "<quantity>"
    When I click Confirm Purchase
    Then the form should reset to defaults

    Examples:
      | deviceType | brand   | storage | color | quantity |
      | phone      | Apple   | 128GB   | Black | 1        |
      | tablet     | Samsung | 64GB    | Silver| 2        |
