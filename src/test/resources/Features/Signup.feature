@signup
Feature: Sign up screen for the user to create login details

  Scenario Outline: User enters existing email to create an account,i want to see if i will get an error message
    Given User is on the signup page
    When User enters name <name>
    And User enters last name <lastname>
    And User enters email <email>
    And User enters new password <password>
    And User enters confirm password <confirmPassword>
    And User clicks on the create account button
    Then User should see an error message <errorMessage>
    When User clicks on the login button
    Then User is redirected to the login page

    Examples:
      | name   | lastname | email          | password    | confirmPassword | errorMessage                                |
      |  Amy    | rams  | Amytest@gmail.com | Password123 | Password123     | User with this email already exists                   |

