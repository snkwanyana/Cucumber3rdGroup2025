Feature: Buying multiple items

  Scenario Outline: User completes all fields correctly
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
    When The user clicks the add to cart button
    Then The item should be added to the cart

# Second item
    When User selects device type order1 <typeOrder2>
    And the user selects brand <brand2>
    And the user selects storage <storage2>
    And the user selects color <color2>
    And the user enters quantity <quantity2>
    And the user enters address <address2>
    And the user clicks the Next button
    Then Step 2 should be displayed
    When The user clicks the add to cart button
    Then The item should be added to the cart

    Examples:
      | typeOrder1 | brand | storage | color | quantity | address                | typeOrder2 | brand2      | storage2 | color2 | quantity2 | address2               | email             | password    | Message |
      | Phone      | Apple | 64GB    | Black | 1        | 123 Main St, Cityville | Laptop     | Macbook pro | 256GB    | White  | 1         | 456 Main St, Cityville | testAmy@gmail.com | Password123 |         |
