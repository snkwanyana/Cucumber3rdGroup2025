@signup
Feature: Sign up screen for the user to create login details

  Scenario Outline: As a user, I want to sign up to get access to Ndosi automation platform
    Given User is on the signup page
    When User enters name <name>
    And User enters last name <lastname>
    And User enters email <email>
    And User enters new password <password>
    And User enters confirm password <confirmPassword>
    And User clicks on the create account button
    Then User should see a message <expectedMessage>

    Examples:
      | name   | lastname | email                | password    | confirmPassword | expectedMessage                                                   |
      | myName | surname  | test@gmail           | Password123 | Password123     | Please enter a valid email address                                |
      | myName | surname  | test@gmail.com       | Passw       | Passw           | Password must be at least 8 characters long                       |
      | myName | surname  | test@gmail.com       | Password123 | Password        | Passwords do not match!                                           |
      | Paper  | Trail    | PaperTrail@gmail.com | Pass1234    | Pass1234        | Registration successful! You can now login with your credentials. |

