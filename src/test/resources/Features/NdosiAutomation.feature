Feature: Ndosi Test Automation

  Scenario Outline: As a user, I want to be able to login to the Ndosi Test Automation website
    Given The user is already on the login page
    When  The user navigates to Learning Materials page
    And The user clicks on Sign Up Here link
    Then The user is redirected to the Sign Up page
    When The user enters the firstname "<firstname>" , lastname "<lastname>", email "<email>" , password "<password>" and confirmPassword "<confirmPassword>"
    And The user clicks on the create account button
    Then The pop up message "Account created successfully" is displayed

    Examples:
      | firstname | lastname  | email               | password | confirmPassword |
      | Lebo1     | Lesedi1   | Lesedi1@test.com    | Test@111 | Test@111        |