Scenario Outline: Login with valid credentials
  Given User is on the login page
  When User enters email<email>
  Then User enters password<password>
  And User clicks on the login button

Examples:
 |email          | password    |
| avnog@gmail.com  | Testing123456|