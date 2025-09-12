Feature: Login screen to access Ndosi automation platform

  Scenario Outline: As a user, I want to log in to access the Ndosi automation platform
    Given User is on the login page
    When User enters Email <email>
    And User enters password <password>
    And User clicks on the login button
    Then User should be redirected to learning material page

    Examples:
      | email            | password  |
      | PlanJa@gmail.com | PlanJ@123 |
