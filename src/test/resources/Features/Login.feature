@login
Feature: Login screen for the user to access Ndosi automation platform

  Scenario Outline: As a user, I want to log in to access Ndosi automation platform
	Given User is on the login page
	When User enters email <email>
	And User enters password <password>
	And User clicks on the login button
	Then User should see an error message <errorMessage>

	Examples:
	  | email          | password | errorMessage                       |
	  | Dani@gmail.com | Test123. |  |
	  | Danwi@gmail.com | Test12   | Login failed: Authentication failed |