Feature: Add Multiple Items to Cart

  Scenario Outline: Add items to cart and check cart updates
    Given I am on the product page
    When I add a "<item>" to the cart
    Then the cart should show "<cartCount>" item(s)

    Examples:
      | item              | cartCount |
      | Step2 item        | 1         |
      | Different device  | 2         |

  Scenario: Apply discount to first item, second item not discounted
    Given I add a "Step2 item" to the cart
    And I add a "Different device" to the cart
    When I apply a discount to the "Step2 item"
    Then only the "Step2 item" should show a discount in its preview text

  Scenario: Remove an item from the cart
    Given I add a "Step2 item" to the cart
    When I remove the "Step2 item" from the cart
    Then the cart should show "<cartCount>" item(s)
    And the Grand Total should be "<grandTotal>"

    Examples:
      | cartCount | grandTotal |
      | 0         | 0.00       |
      | 1         | 200.00     |

  Scenario: Remove the last item from the cart
    Given I add a "Step2 item" to the cart
    When I remove the "Step2 item" from the cart
    Then the cart panel should be hidden

  Scenario: Try to add an item with missing storage
    Given I try to add a "Step2 item" with missing storage
    Then an error message should appear
    And the cart count should remain unchanged
