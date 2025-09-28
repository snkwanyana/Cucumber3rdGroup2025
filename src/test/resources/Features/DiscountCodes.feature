Feature: Discount code application

  Scenario Outline: Applying discount codes
    Given I am on the pricing page
    When I enter "<code>" in the discount code field and click Apply
    Then I should see the message "<message>"

    Examples:
      | code    | message                        |
      | SAVE10  | Code SAVE10 applied: -10%      |
      | SAVE20  | Code SAVE20 applied: -20%      |
      | random  | Invalid code                   |

      # Scenario for clearing the discount code field
  Scenario: Clearing the discount code removes the message
    Given I have applied "SAVE10" discount code
    When I clear the discount code field and apply
    Then I should not see any discount message
