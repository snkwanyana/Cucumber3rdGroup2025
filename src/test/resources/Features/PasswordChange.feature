Feature: Password Change

  Scenario Outline: Handle various password change outcomes
    Given I am on the password change page
    When I enter old password "<oldPassword>", new password "<newPassword>", and confirm password "<confirmPassword>"
    And I click the update password button
    Then I should see the message "<expectedMessage>"

    Examples:
      | oldPassword | newPassword | confirmPassword | expectedMessage                              |
      |              |             |                  | Error: All fields are required               |
      | old123       | new123      | new124           | Error: New passwords do not match            |
      | old123       | short       | short            | Error: New password must be at least 6 characters long |
      | old123       | valid123    | valid123         | Success: Password changed successfully       |

  Scenario: Check visibility toggles
    Given I am on the password change page
    When I toggle all password visibility icons
    Then all password fields should toggle visibility successfully
