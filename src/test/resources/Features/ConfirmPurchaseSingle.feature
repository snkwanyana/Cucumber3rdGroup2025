Feature: Confirm Purchase (Single)

  Scenario Outline: Single purchase confirmation and invoice generation
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
    When The user clicks the add to cart button
    Then The item should be added to the cart
    When I click the Review Cart Order button
    And I click the Place Order button
    Then a success toast should show a personalized message for "Amy"
    And the toast should include an Order Details box, Total amount, and timestamp
    And the success popup should have a dismiss button in the top-right corner
    And the popup should not auto-dismiss
    And the success popup should have a "View History" button in the bottom-right corner
    #we don't have view history button but view invoice button
    When the user clicks the "View History" button
    Then the invoice history should expand and scroll to the invoice section
    And an invoice with a unique ID should be generated and stored in history (last 10 invoices)
    And the cart should remain unchanged except for the purchased item
    #And the toast should only display the current purchased item

    Examples:
      | typeOrder1 | brand | storage | color | quantity | address                | email             | password    | Message | code   | message                   |TestUser|
      | Phone      | Apple | 64GB    | Black | 1        | 123 Main St, Cityville | testAmy@gmail.com | Password123 |         | SAVE10 | Code SAVE10 applied: -10% | Amy    |


