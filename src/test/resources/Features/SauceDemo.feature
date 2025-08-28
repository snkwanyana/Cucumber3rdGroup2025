Feature: Sauce Demo

  Scenario Outline: As a user, I want to be able to login to the Sauce Demo website
    Given The user is already on the login page
    When The user enters the username <username>
    And The user enters the password <password>
    And The user clicks on the login button
    Then The user should be redirected to the homepage

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |