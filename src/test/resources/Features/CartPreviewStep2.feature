Feature: Cart Preview Panel (Step2)

  Scenario Outline: Cart preview appears after adding items
    Given I am on the product page
    When I add a "<deviceType>" "<brand>" "<storage>" to the cart
    Then the cart preview should be visible
    And the cart preview should show "<expectedTitle>"

    Examples:
      | deviceType | brand   | storage | expectedTitle |
      | phone      | Apple   | 128GB   | Cart (1 item) |
      | tablet     | Samsung | 64GB    | Cart (1 item) |

  Scenario Outline: Remove item updates preview instantly
    Given I have added a "<deviceType>" "<brand>" "<storage>" to the cart
    When I remove the preview item
    Then the cart preview should be hidden

    Examples:
      | deviceType | brand   | storage |
      | phone      | Apple   | 128GB   |
      | tablet     | Samsung | 64GB    |
