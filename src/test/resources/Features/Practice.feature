@Regression

Feature: Practice Assessments page to access Web Automation in Ndosi platform

  Background:
    Given User is on the login page
    When User enters Email meta@outlook.com
    And User enters password P@ssword123
    Then User clicks on the login button


  Scenario Outline: As a user, I want to access the practice assessments page to take web automation assessment
    Given User is on the practice assessments page
    When User clicks on the web automation link
    And  User selects device type <deviceType>
    And User selects brand <brand>
    And User selects storage <storage>
    And User selects color <color>
    And User enters quantity <quantity>
    And User enters delivery address <deliveryAddress>
    Then User clicks on the next button

    Examples:
      | deviceType | brand       | storage | color | quantity | deliveryAddress        |
      | Laptop     | Macbook pro | 256GB   | White | 4        | 123, Baker street, SA  |
      | Phone      | Apple       | 128GB   | Black | 2        | 221B, Baker street, SA |
      | Tablet     | Samsung     | 64GB    | Blue  | 1        | 10, Downing street, SA |




