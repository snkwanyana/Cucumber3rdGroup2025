Feature: Discount code application

  Scenario Outline: Applying discount codes
    Given User is on the login page
    When The user enters email <email>
    And The user enters new password <password>
    And The User click on the login button
    Then The User should be logged in successfully
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
    When I enter "<code>" in the discount code field and click Apply
    Then I should see the message "<message>"

    Examples:
      | code    | message                        | typeOrder1 | brand | storage | color | quantity | address                | email             | password    |
      | SAVE10  | Code SAVE10 applied: -10%      | Phone      | Apple | 64GB    | Black | 1        | 123 Main St, Cityville | testAmy@gmail.com | Password123 |
      | SAVE20  | Code SAVE20 applied: -20%      | Phone      | Apple | 64GB    | Black | 1        | 123 Main St, Cityville | testAmy@gmail.com | Password123 |
      | random  | Invalid code                   | Phone      | Apple | 64GB    | Black | 1        | 123 Main St, Cityville | testAmy@gmail.com | Password123 |

      # Scenario for clearing the discount code field
  #Scenario: Clearing the discount code removes the message
   # Given I have applied "SAVE10" discount code
   # When I clear the discount code field and apply
  #  Then I should not see any discount message
    Given User is on the login page
    When The user enters email <email>
    And The user enters new password <password>
    And The User click on the login button
    Then The User should be logged in successfully
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
    When I enter "<code>" in the discount code field and click Apply
    Then I should see the message "<message>"
    When I clear the discount code field and apply
    Then I should not see any discount message
