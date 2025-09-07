Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When the user logs in with username and password
    Then User should see a welcome message

