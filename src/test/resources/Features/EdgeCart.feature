Feature: Edge / Negative Cart Scenarios

  Scenario Outline: Verify quantity limit validation
    Given I have added "<deviceType>" "<brand>" "<storage>" to the cart
    When I set the quantity to "<quantity>"
    Then I should see the quantity error message "<expectedMessage>"

    Examples:
      | deviceType | brand | storage | quantity | expectedMessage            |
      | phone      | Apple | 128GB   | 999      | Quantity must be ≤ 10.     |

  Scenario Outline: Removing discounted item updates total correctly
    Given I have added a discounted "<deviceType>" "<brand>" "<storage>" to the cart
    And I have added a non-discounted "<secondDeviceType>" "<secondBrand>" "<secondStorage>" to the cart
    When I remove the discounted item
    Then the grand total should update correctly and no discounts should remain

    Examples:
      | deviceType | brand | storage | secondDeviceType | secondBrand | secondStorage |
      | phone      | Apple | 128GB   | tablet           | Samsung     | 64GB          |

  Scenario Outline: Guard against placing order with empty cart
    Given I manually empty the cart
    When I attempt to place the order
    Then no success toast should appear

    Examples:
      | dummy |
      | test  |
