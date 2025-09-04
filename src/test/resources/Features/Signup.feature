Feature: Sign up screen for the user to create login details

  Scenario Outline: As a user, I want to sign up to get access to Ndosi automation platform
    Given User is on the signup page
    When User enters name <name>
    And User enters last name <lastname>
    And User enters email <email>
    And User enters new password <password>
    And User enters confirm password <confirmPassword>
    And User clicks on the create account button
    Then User should see an error message <errorMessage>

    Examples:
      | name   | lastname | email          | password    | confirmPassword | errorMessage                                |
      |        | surname  | test@gmail.com | Password123 | Password123     | Please fill in all fields                   |
      | myName | surname  | test@gmail.com | Password123 | Password123     | Please enter a valid email address          |
      | myName | surname  | test@gmail.com | Password123 | Password123     | Password must be at least 8 characters long |
      | myName | surname  | test@gmail.com | Password123 | Password123     | Passwords do not match!                     |

