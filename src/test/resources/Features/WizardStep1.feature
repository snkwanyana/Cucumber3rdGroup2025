Feature: Purchase a Device from Practice Assessments

  @purchase
  Scenario Outline: Wizard Step 1 validation

    Given user logs in with valid credentials
    When navigate to Practice Assessments
    And the user selects device type "<deviceType>"
    And the user selects brand "<brand>"
    And the user selects storage "<storage>"
    And the user sets quantity "<quantity>"
    And the user enters delivery address "<address>"
    And the user clicks Purchase Device "<expectedResult>"
    Then the user should see an error message "<expectedResult>"
    Examples:
      | deviceType | brand    | storage | quantity | address        | expectedResult               |
      | Phone      | Samsung  | 64GB    | 0        | 123 Main St    | QUANTITY MUST BE ≥ 1       |
      | Phone      | Samsung  | 64GB    | 11      | 123 Main St    |  QUANTITY MUST BE ≤ 10        |
      | Phone      | Samsung  | 128GB   | 1        |                | NextDisabled                 |
      | Phone      |          | 256GB   | 1        | 456 Oak Ave    | NextDisabled                |
      | Laptop     | Macbook pro |      | 1        | 789 Pine Rd    | NextDisabled                |
      | Tablet     | Apple  | 64GB    | 1        | 321 Maple St   | Order placed successfully!   |