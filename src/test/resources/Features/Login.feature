@login
Feature: Login and Session Management

  Scenario Outline: Successful login and session timeout handling
    Given I am on the login page
    When I enter email <email> and password <password> and click login
    Then I should see all tabs
    And localStorage should contain authToken
    When I navigate to a different menu tab
    And I return to the original tab
    Then I should be redirected to the login page due to session timeout
    When I re-enter email <email> and password <password> and click login again
    And I click the logout button
    Then I should be redirected to the login page

    Examples:
      | email                 | password       |
      | Elizabeth@england.com | England@123456 |

  Scenario Outline: Login fails with invalid password
    Given I am on the login page
    When I enter a valid email <email> and an invalid password <invalid_password>
    Then I should see an alert containing <expectedMessage>
    Examples:
      | email                 | invalid_password | expectedMessage           |
      | Elizabeth@england.com | WrongPass@1      | Invalid email or password |