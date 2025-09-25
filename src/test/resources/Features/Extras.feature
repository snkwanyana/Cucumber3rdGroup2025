@Regression
Feature: Extras page to access Web Automation in Ndosi platform

  Background:
    Given User is on the login page
    When User enters Email meta@outlook.com
    And User enters password P@ssword123
    And User clicks on the login button
    And User is on the practice assessments page
    And User clicks on the web automation link
    And  User selects device type Laptop
    And User selects brand Macbook pro
    And User selects storage 256GB
    And User selects color White
    And User enters quantity 4
    And User enters delivery address 123, Baker street, London
    And User clicks on the next button


  Scenario Outline: As a user, I want to access the practice assessments page to take web automation assessment
    When User selects shipping method <shippingMethod>
    And User selects warranty <warranty>
    And User enters a discount code <discountCode>
    And User clicks on apply discount button
    And User clicks on the confirm purchase button

    Examples:
      | shippingMethod  | warranty      | discountCode |
      | Standard (+R0)  | No Warranty   | SAVE0        |
      | Express (+R25)  | 1 Year (+R49) | SAVE10       |
      | Next Day (+R50) | 2 Year (+R89) | SAVE20       |
