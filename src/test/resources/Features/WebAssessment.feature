@webAssessment
Feature: Web Automation Device Purchase


  Scenario Outline: User fills Web Automation form and submits successfully

    Given the user is on the login page
    When the user enters email "ree@test.com"
    And the user enters password "Password@123"
    And the user clicks the login button

    When the user clicks the "Web Automation" tab
    And the user selects device type "<deviceType>"
    And the user selects brand "<brand>"
    And the user selects storage "<storage>"
    And the user selects color "<color>"
    And the user sets quantity "<quantity>"
    And the user enters delivery address "<deliveryAddress>"

    And the user clicks Purchase Device
    Then the success toast should appear with order summary

    Examples:
      | deviceType | brand   | storage | color | quantity | deliveryAddress            |
      | Phone      | Apple   | 128GB   | Gold  | 2        | 123 Main Street, City      |
#      | Laptop     | Dell    | 256GB   | Silver| 1        | 456 Elm Street, Town       |
#      | Tablet     | Samsung | 64GB    | Black | 3        | 789 Oak Avenue, Village    |