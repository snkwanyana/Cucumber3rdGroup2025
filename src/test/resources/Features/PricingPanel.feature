Feature: Step 2 Pricing Panel

 # Scenario: No device and storage selected
  #  Given the user is on Step 2 of the ordering wizard
   # When no device type and storage are selected
    #Then the base price should display "—"
   # And the subtotal should display "—"

  Scenario Outline: As user i want to select Phone 64GB, quantity 1 and see correct unit price and subtotal
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
    Then the unit price should be <basePrice>
    And the subtotal should be <subtotal>



    Examples:
      | typeOrder1 | brand | storage | color | quantity | basePrice | subtotal | email             | password    |
      | Phone      | Apple | 64GB    | Black | 1        | R400.00   | R400.00  | testAmy@gmail.com | Password123 |

  Scenario Outline: As user i want to select Phone 128GB, quantity 2 and see correct unit price and subtotal
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
    Then the unit price should be <basePrice>
    And the subtotal should be <subtotal>

    Examples:
      | typeOrder1 | brand | storage | color | quantity | basePrice | subtotal | email             | password    |
      | Phone      | Apple | 128GB   | Black | 2        | R480.00   | R960.00  | testAmy@gmail.com | Password123 |

 # Scenario: Laptop 256GB, quantity 1
  Scenario Outline: As user i want to select Laptop 256GB, quantity 1 and get correct unit price and subtotal
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
    Then the unit price should be <basePrice>
    And the subtotal should be <subtotal>

    Examples:
      | typeOrder1 | brand | storage | color | quantity | basePrice | subtotal | email             | password    |
      | Laptop     | Macbook pro | 256GB   | Black | 1        | R1360.00  | R1360.00 | testAmy@gmail.com | Password123 |

 # Scenario: Clear device selection
 #   Given the user selects "Phone" as device type
 #   And the user selects "64GB" as storage
  #  And the user enters quantity "1"
  #  When the user clears the device type selection and proceeds to Step 2
  #  Then the base price should display "—"
  #  And the subtotal should display "—"