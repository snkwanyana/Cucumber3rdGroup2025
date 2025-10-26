Feature: Invoice Generation & Management



  Scenario Outline: Automatic invoice creation after purchase
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
    When the user clicks the "View History" button
    Then the invoice history should expand and scroll to the invoice section
    And an invoice with a unique ID should be generated and stored in history (last 10 invoices)
    When the user clicks the view button for the latest invoice
    Then the invoice should open in a new tab
    And the invoice should include the company logo, customer details, itemized list, totals, and professional formatting
    And the invoice should be stored with customerName, customerEmail, deliveryAddress, items, total, and htmlContent

    Examples:
      | typeOrder1 | brand | storage | color | quantity | address                | email             | password    | Message | code   | message                   |TestUser|
      | Phone      | Apple | 64GB    | Black | 1        | 123 Main St, Cityville | testAmy@gmail.com | Password123 |         | SAVE10 | Code SAVE10 applied: -10% | Amy    |

 # Scenario: Invoice history panel displays last 10 invoices
  #  Given the user has made more than 10 purchases
  #  When the user opens the invoice history panel
  #  Then only the last 10 invoices should be displayed
  #  And each invoice should have view, download, and delete options

 # Scenario: Viewing an invoice opens in new tab with correct HTML format
 #   When the user clicks the view button for an invoice
 #   Then the invoice should open in a new tab
  #  And the HTML should match the professional invoice design

 # Scenario: Downloading an invoice as PDF
  #  When the user clicks the download button for an invoice
 #   Then a PDF should be generated using jsPDF
  #  And the PDF should include the company logo, proper spacing, and page boundaries
  #  And the Bill To section should show the customer name, email, and delivery address
 #   And the layout should have the company logo top-left, company info top-right, and proper margins

 # Scenario: Deleting an invoice from history
 #   When the user clicks the delete button for an invoice
  #  And confirms the deletion
   # Then the invoice should be removed from the history
   # And the invoice count should update

  #Scenario: Clearing all invoices from history
  #  When the user clicks the clear all invoices button
   # And confirms the bulk deletion
  #  Then all invoices should be removed from the history
   # And the invoice count should be zero

  #Scenario: Invoice counter displays correct count
  #  When the user opens the invoice history panel
  #  Then the header should show "📄 Invoices (X)" with the current invoice count

