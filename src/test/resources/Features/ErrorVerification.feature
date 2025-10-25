Feature: Exact Error Strings (Verify)

  Scenario Outline: Validate field error messages
    Given I am on the product page
    When I trigger validation for "<errorCase>"
    Then I should see the exact error message "<expectedMessage>"

    Examples:
      | errorCase              | expectedMessage                             |
      | missingDeviceType      | Select a device type                        |
      | missingBrand           | Select a brand                              |
      | missingStorage         | Choose storage size                         |
      | quantityBelowMin       | Quantity must be ≥ 1                        |
      | quantityAboveMax       | Quantity must be ≤ 10                       |
      | missingAddress         | Address required                            |
      | invalidDiscountCode    | Invalid code                                |
      | invalidLogin           | Invalid login credentials                   |
      | errorSummary           | Please correct highlighted fields.          |
