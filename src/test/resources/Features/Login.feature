@login
Feature: Login  screen for the user to login

  Scenario Outline: User submits correct credentials to get access to Ndosi automation platform
    Given User is on the login page
    When The user enters email <email>
    And The user enters new password <password>
    And The User click on the login button
    Then The User should be logged in successfully
    And The User token presence should be <tokenPresent>

    Examples:
      | email             | password    | tokenPresent |
      | testAmy@gmail.com | Password123 | false        |
      | testAmy@gmail.com | Password123 | true         |

  Scenario Outline: User submits invalid credentials
    Given User is on the login page
    When The user enters email <email>
    And The user enters new password <password>
    When The User click on the login button
    Then The error message should be displayed <Message>




    Examples:
      | email             | password     | Message                   |
      | testAmy@gmail.com | Password1234 | Invalid email or password |

  Scenario Outline: User should be logged out when the switch tabs
    Given User is on the login page
    When The user enters email <email>
    And The user enters new password <password>
    When The User click on the login button
    Then The User should be logged in successfully
    When The user switch to new tab
    Then The User should be logged out




    Examples:
      | email             | password    |
      | testAmy@gmail.com | Password123 |
