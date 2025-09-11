@login
Feature: User Login

  Scenario Outline: Login attempts with different credentials
    Given the user is on the login page
    When the user enters email "<email>"
    And the user enters password "<Password>"
    And the user clicks the login button
    Then the user should see ExpectedMessage "<expectedMessage>"

    Examples:
      | email          | Password      | expectedMessage                          |
      | wrong@test.com | Password@123  | Login failed: Authentication failed      |
      |                | Password@123  | Login failed: Missing required fields    |
      | ree@test.com   | Password@123  | Logout                                   |
