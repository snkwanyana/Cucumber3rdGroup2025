@login
Feature: Login screen for the user to login to ...

  Scenario Outline: As a user, I want to log in to get access to Ndosi automation platform
    Given User is on the login page
    When User enters name <email>
    And User enters new password <password>
    And User clicks on the login button
    Then User should see directed to the

    Examples:
      | email          | password    |
      | test@gmail.com | Password123 |
      | test@gmail     | Password123 |
      | test@gmail.com | Passw       |
      | test@gmail.com | Password123 |
