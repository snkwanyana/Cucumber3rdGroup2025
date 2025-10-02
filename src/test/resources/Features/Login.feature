@login
Feature:Login to Ndosi automation platform

  Scenario Outline: As a user, I want to login to Ndosi automation platform
    Given User is on the login page
    When User enters email <email>
    And User enters password <password>
    And User clicks on login button
    Then User should be able to login

    Examples:
      | email          | password    |
      | email@test.com | password123 |

