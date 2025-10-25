Feature: Login & Registration functionality



   @login
   Scenario Outline: Login with different credentials
     Given I navigate to the login page
     When I enter username "<username>" and password "<password>"
     And I click on the login button
     Then I should see "<expectedResult>"

     Examples:
       | username       | password       | expectedResult              |
       | ree@test.com   | Password@123   | logout                      |
       | testuser       | wrongpass      | Invalid email or password   |
       | ree@test.com   | Password@123   | logout                      |

   @session
   Scenario: Switch tab and back requires re-login
     When I login with valid credentials
     And I switch to another tab and back
     Then I must be forced to login again

   @logout
   Scenario: Logout clears token and shows login screen
     When I login with valid credentials
     And I click logout
     Then Token is removed and login screen is visible
