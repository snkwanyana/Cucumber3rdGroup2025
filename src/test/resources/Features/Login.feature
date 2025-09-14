@login
Feature: Login page to allow user to access

  Background: User is on the login page
#    Given I navigate to the login page

  Scenario Outline: As a user, I want to validate login with valid and invalid credentials
    Given I navigate to the login page
    When User enter the username <username>
    And User enter the password <password>
    And User clicks on the login button
    Then User confirms the above steps executed successfully <loginMessage>

    Examples:
      | username        | password | loginMessage                        |
      | sbuda@gmail.com | 12345678 |                                     |
      | sbuda@gmail.com | 87654321 | Login failed: Authentication failed |
      | sbuda@gmail.com | 12345678 |                                     |

  Scenario Outline: As a user, I want to ensure the user is logged out when switching between different taps
    Given I navigate to the login page
    When User enter the username <username>
    And User enter the password <password>
    And User clicks on the login button
    Then User confirms the above steps executed successfully <loginMessage>
    When User switch to any tab and back to learning materials tab
    Then User confirms the user is logged out and redirected to the login page

    Examples:
      | username        | password | loginMessage                        |
      | sbuda@gmail.com | 12345678 |                                     |

  Scenario Outline: As a user, I want to ensure the user is logged out successfully
    Given I navigate to the login page
    When User enter the username <username>
    And User enter the password <password>
    And User clicks on the login button
    Then User confirms the above steps executed successfully <loginMessage>
    When User clicks on the logout button
    Then User confirms the user is logged out and redirected to the login page

    Examples:
      | username        | password | loginMessage                        |
      | sbuda@gmail.com | 12345678 |                                     |