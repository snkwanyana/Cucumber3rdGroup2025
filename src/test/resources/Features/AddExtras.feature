@AddExtras

Feature: User is logged in and wants to add extras to the order

  Scenario Outline: As a user, I want to Add extras to my order
    Given User clicks on the shipping method radio button
    When User clicks on warranty radio button
    And User enters discount code <DiscountCode>
    And User clicks on Apply button


    Examples:
      | DiscountCode|
      |save20 |