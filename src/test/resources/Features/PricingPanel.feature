Feature: Step 2 Pricing Panel

 # Scenario: No device and storage selected
  #  Given the user is on Step 2 of the ordering wizard
   # When no device type and storage are selected
    #Then the base price should display "—"
   # And the subtotal should display "—"

  Scenario Outline: Phone 64GB, quantity 1
    Given User is on the Form page
    Then user selects device type price panel <type price panel>
    And  user selects brand <brand>
    And  user selects storage <storage>
    And user selects color <color>
    And  user enters quantity <quantity>
    And  user enters address <address>
    When  user clicks the Next button
    Then Pricing Panel should be displayed
    Then the base price should display <basePrice>
    And the subtotal should display <subtotal>
    Examples:
      | type price panel | brand | storage | color | quantity | address                |basePrice|subtotal|
      | Phone            | Apple | 64GB   | Black | 1        | 123 Main St, Cityville | R400.00   | R400.00 |

 # Scenario: Phone 128GB, quantity 2
  #  Given the user selects "Phone" as device type
  #  And the user selects "128GB" as storage
  #  And the user enters quantity "2"
   # When the user proceeds to Step 2
   # Then the base price should display "R480.00"
   # And the subtotal should display "R960.00"

 # Scenario: Laptop 256GB, quantity 1
  #  Given the user selects "Laptop" as device type
  #  And the user selects "256GB" as storage
 #   And the user enters quantity "1"
  #  When the user proceeds to Step 2
  #  Then the base price should display "R1,360.00"
  #  And the subtotal should display "R1,360.00"

 # Scenario: Clear device selection
 #   Given the user selects "Phone" as device type
 #   And the user selects "64GB" as storage
  #  And the user enters quantity "1"
  #  When the user clears the device type selection and proceeds to Step 2
  #  Then the base price should display "—"
  #  And the subtotal should display "—"