Feature: Step 1 Pricing Panel

  @pricing
  Scenario Outline: Verify pricing updates correctly based on device selection
    Given user logs in with the valid credentials
    When navigate to the Practice Assessments
    And the user selects the device type "<deviceType>"
    And the user selects the storage "<storage>"
    And the user sets the quantity "<quantity>"
    Then the pricing panel should show "<unitPrice>" and Subtotal "<subtotal>"

    Examples:
      | deviceType | storage | quantity | unitPrice   | subtotal    |
      |            |         |          | Unit: —     | —           |
      | Phone      | 64GB    | 1        | R400.00     | R400.00     |
      | Phone      | 128GB   | 2        | R480.00     | R960.00     |
      | Laptop     | 256GB   | 1        | R1360.00    | R1360.00    |

  @pricingReset
  Scenario: Clearing device resets pricing
    Given user logs in with valid credentials
    When navigate to Practice Assessments
    And the user clears the device selection
    Then the pricing panel should show Unit "—" and Subtotal "—"
