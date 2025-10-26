Feature: Review Cart Order Flow
  As a user
  I want to review my cart and place an order with confirmation and invoice
  So that I can verify my order before finalizing


  Scenario Outline: Review cart and see Place Order/Cancel buttons and info box
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
    When I enter "<code>" in the discount code field and click Apply
    Then I should see the message "<message>"
    When The user clicks the add to cart button
    Then The item should be added to the cart
    When I click the Review Cart Order button
    Then the Place Order and Cancel buttons and info box should appear

    Examples:
      | typeOrder1 | brand | storage | color | quantity | address                |email             | password    | Message | code    | message                        |
      | Phone      | Apple | 64GB    | Black | 1        | 123 Main St, Cityville |testAmy@gmail.com | Password123 |         |  SAVE10  | Code SAVE10 applied: -10%      |

  Scenario Outline: Cancel reverts to single Review Cart Order button
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
    When I enter "<code>" in the discount code field and click Apply
    Then I should see the message "<message>"
    When The user clicks the add to cart button
    Then The item should be added to the cart
    When I click the Review Cart Order button
    And I click the Cancel button in the cart
    Then only the Review Cart Order button should be visible

    Examples:
      | typeOrder1 | brand | storage | color | quantity | address                |email             | password    | Message | code    | message                        |
      | Phone      | Apple | 64GB    | Black | 1        | 123 Main St, Cityville |testAmy@gmail.com | Password123 |         |  SAVE10  | Code SAVE10 applied: -10%      |


  Scenario Outline: Place Order shows personalized success toast and order info
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
    When I enter "<code>" in the discount code field and click Apply
    Then I should see the message "<message>"
    When The user clicks the add to cart button
    Then The item should be added to the cart
    When I click the Review Cart Order button
    And I click the Place Order button
    Then a success toast should show a personalized message for "Amy"
    And the success toast should show order info with user name, items, and grand total
    And the success popup should have dismiss and View History buttons and not auto-timeout

    Examples:
      | typeOrder1 | brand | storage | color | quantity | address                |email             | password    | Message | code    | message                        |
      | Phone      | Apple | 64GB    | Black | 1        | 123 Main St, Cityville |testAmy@gmail.com | Password123 |         |  SAVE10  | Code SAVE10 applied: -10%      |

 # Scenario Outline: Double-click Place Order only shows one toast
  #  Given User is on the login page
   # When The user enters email <email>
  #  And The user enters new password <password>
 ##   Then The error message should be displayed <Message>
  #  And The User should be logged in successfully
  #  Then User is on the Form page
  #  When The User clicks on the Web Automation Button
  #  When User selects device type order1 <typeOrder1>
 #   And the user selects brand <brand>
 #   And the user selects storage <storage>
 #   And the user selects color <color>
  #  And the user enters quantity <quantity>
 #   And the user enters address <address>
 #   And the user clicks the Next button
 #   Then Step 2 should be displayed
 #   When I enter "<code>" in the discount code field and click Apply
 #   Then I should see the message "<message>"
 #   When The user clicks the add to cart button
 #   Then The item should be added to the cart
 #   When I click the Review Cart Order button
  #  And I double-click the Place Order button quickly
 #   Then only one success toast should be visible

  #  Examples:
  #    | typeOrder1 | brand | storage | color | quantity | address                |email             | password    | Message | code    | message                        |
  #    | Phone      | Apple | 64GB    | Black | 1        | 123 Main St, Cityville |testAmy@gmail.com | Password123 |         |  SAVE10  | Code SAVE10 applied: -10%      |

