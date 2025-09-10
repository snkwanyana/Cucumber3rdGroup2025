@login
Feature: As a user, I want to log in to access the Ndosi automation platform

  Scenario Outline: As a user, I want to log in to access the Ndosi automation platform
    Given User is on the login page
    When User enters username <username>
    And User enters password <password>
    And User clicks on the login button
    Then User should see the homepage or an error message <errorMessage>

    Examples:
      | username     | password     | errorMessage                          |
      |              |              | Login failed: Missing required fields |
      | md@gmail.com |              | Login failed: Missing required fields |
      |              | secret_sauce | Login failed: Missing required fields |
      | md@gmail.com | emd12345     |                                       |

