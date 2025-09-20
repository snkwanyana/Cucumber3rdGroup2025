@login

Feature: Login screen for the user to access Ndosi automation platform

  Scenario Outline: As a user, I want to log in to access Ndosi automation platform
    Given User is on the homepage
    When User clicks on the learning material button
    And User enters emailaddress <emailaddress>
    And User enters password <password>
    And User clicks on the login button
    And User clicks on About Us button
    Then User should see About Nkosi Cele
    And User clicks on the learning material button
    And User if forced to login again
    And User Clicks on Web Automation Advance
    And User select the device
    And User Select the brand
    And User select the storage


    Examples:
      | emailaddress       | password    |
      |sama23@gmail.com  | Password123 |