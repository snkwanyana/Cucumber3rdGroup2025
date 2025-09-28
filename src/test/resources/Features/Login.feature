@login
Feature: Login  screen for the user to login

  Scenario Outline: As a user, I want to log in to get access to Ndosi automation platform
    Given User is on the login page
    When The user enters email <email>
    And The user enters new password <password>
    And The User click on the login button
    Then The user should see the message <Message>
    And The User should be logged in successfully
  #  And The User session state should be <sessionState>
    #And The User tabs visibility should be <tabsVisible>
   # And The User token presence should be <tokenPresent>
  #  When The User switches tab and returns
  #  Then The user should see the login page again
 #   When The User logs in again with <email> and <password>
  #  And The User clicks logout
   # Then The User token presence should be <tokenAfterLogout>
   # And The user should see the login page again


    Examples:
      | email             | password     | Message                   |
      | testAmy@gmail.com | Password123  |                           |
      | testAmy@gmail.com | Password1234 | Invalid email or password |
      | testAmy@gmail.com | Password123  |                           |

