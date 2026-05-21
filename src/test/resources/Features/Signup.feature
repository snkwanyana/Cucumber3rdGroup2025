@signup
Feature: Sign up screen for the user to create login details

  Scenario Outline: As a user, I want to sign up to get access to Ndosi automation platform
    Given User is on the signup page
    When User enters name <name>
    And User enters last name <lastname>
    And User enters email <email>
    And User enters new password <password>
    And User enters confirm password <confirmPassword>
    And User selects group <groupName>
    And User clicks on the create account button
    Then User should see a message <expectedMessage>

    Examples:
      | name   | lastname | email             | password     | confirmPassword | groupName             | expectedMessage                                                              |
      | myName | surname  | test@gmail        | Password@123 | Password@123    | 1st Group 2026 (2026) | Please enter a valid email address                                           |
      | myName | surname  | test@gmail.com    | Passw@       | Passw@          | 2nd Group 2026 (2026) | Password must be at least 8 characters long                                  |
      | myName | surname  | test@gmail.com    | Password@123 | Password        | 2nd Group 2026 (2026) | Passwords do not match!                                                      |
      | Castle | Jaguar   | Lafae23@gmail.com | Password@123 | Password@123    | 1st Group 2026 (2026) | Registration submitted successfully. Your account is pending admin approval. |

