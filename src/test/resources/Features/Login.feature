@Regression

Feature: Login screen to access Ndosi automation platform

  Scenario Outline: As a user, I want to log in to access the Ndosi automation platform
    Given User is on the login page
    When User enters Email <email>
    And User enters password <password>
    Then User clicks on the login button


    Examples:
      | email            | password    |
      | meta@outlook.com | P@ssword123 |
