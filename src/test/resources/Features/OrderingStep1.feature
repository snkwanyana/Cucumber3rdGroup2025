Feature: Ordering Wizard Step 1 - Device Selection and Validation

  @orderingStep1
 # Scenario: User submits form with all fields blank
 #   Given the user is on the ordering page
 #   When the user has not clicked on any fields
 #   Then the device type should display "select"
  #  And the device type error should display "Select a device type"
   # And the brand error should display "Select a brand"
   # And the storage error should display "Choose storage size"
   # And the quantity error should display "Quantity must be ≥ 1"
   # And the address error should display "Address required"



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

    Examples:


      | typeOrder1 | brand | storage | color | quantity | address                | email             | password     | Message                   |
      | Phone      | Apple | 64GB    | Black | 1        | 123 Main St, Cityville | testAmy@gmail.com | Password123  |                           |