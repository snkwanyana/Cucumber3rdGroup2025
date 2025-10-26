Feature: Pricing calculation with various options

  Scenario Outline: Pricing calculation with various options
    Given User is on the login page
    When The user enters email <email>
    And The user enters new password <password>
    And The User click on the login button
    Then The error message should be displayed <Message>
    And The User should be logged in successfully
    Then User is on the Form page
    When The User clicks on the Web Automation Button
    When User selects device type order1 <typeOrder1>
    And the user selects brand <brand>
    And the user selects storage <storage>
    And the user selects color <color>
    And the user enters quantity <quantity>
    And the user enters address <address>
    And the user clicks the Next button
    Then Step 2 should be displayed
    When the user selects <shipping> shipping
    And selects "<warranty>" warranty
    And I enter "<code>" in the discount code field and click Apply
    And the quantity on price breakdown should be <quantity>
    Then the base price on price breakdown should be <base>
    And the subtotal on price breakdown should be <subtotal>
    And the discount on price breakdown should be <discountValue>
    And the total on Price breakdown should be <total>

    Examples:
      | shipping | warranty | code   | quantity | base    | subtotal | discountValue | total   | typeOrder1 | brand | storage | color | address                | email             | password    |
      | Standard | None     | SAVE10 | 1        | R400.00 | R400.00  | - R40.00      | R360.00 | Phone      | Apple | 64GB    | Black | 123 Main St, Cityville | testAmy@gmail.com | Password123 |
      | Express  | 1yr      | SAVE10 | 2        | R400.00 | R800.00  | - R82.50      | R742.50 | Phone      | Apple | 64GB    | Black | 123 Main St, Cityville | testAmy@gmail.com | Password123 |
      | Express  | 2yr      | SAVE10 | 1        | R400.00 | R400.00  | - R42.50      | R382.50 | Phone      | Apple | 64GB    | Black | 123 Main St, Cityville | testAmy@gmail.com | Password123 |