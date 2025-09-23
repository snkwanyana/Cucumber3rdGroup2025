@AddExtras

Feature: Login screen for the user to access Ndosi automation platform

  Scenario Outline: As a user, I want to Add extras to my order
    Given User is on the extras page
    When User clicks on the shipping method radio button
    And User clicks on warranty radio button
    And User enters discount code <DiscountCode>
    And User clicks on Apply button


    Examples:
      | DiscountCode|
      |save20 |