@loginInva

Feature: Login screen for the user to access Ndosi automation platform

  Scenario Outline: As a user, I want to log in to access Ndosi automation platform
    Given User is on the homepage
    When User clicks on the learning material button
    And User enters emailaddress <emailaddress1>
    And User enters password <password>
    And User clicks on the login button

    Examples:
      | emailaddress1    | password |
      | sama23@gmail.com | Password |