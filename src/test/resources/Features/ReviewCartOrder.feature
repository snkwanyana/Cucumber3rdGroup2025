Feature: Review Cart Order Flow

  Scenario: Review Cart Order buttons appear
    Given I am on the cart page
    When I click Review Cart Order
    Then Place Order and Cancel buttons with info box should appear

  Scenario: Cancel review order
    Given I clicked Review Cart Order
    When I click Cancel
    Then the Review Cart Order button should be visible again

  Scenario Outline: Place order and verify success
    Given I clicked Review Cart Order
    When I click Place Order
    Then a success toast should appear with message "<expectedMessage>"
    And the success popup should show user "<userName>" with cart items and grand total
    And the invoice should be generated with all items and totals

    Examples:
      | userName | expectedMessage                                |
      | JohnDoe  | JohnDoe, your order was purchased successfully! |

  Scenario: Success popup controls
    Given I placed an order
    Then the success popup should have dismiss and view history buttons

  Scenario: Double-click Place Order safety
    Given I clicked Review Cart Order
    When I double-click Place Order quickly
    Then only one success toast should appear
