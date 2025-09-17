@login
Feature: Login screen for the user to access Ndosi automation platform

  Scenario Outline: As a user, I should see an error message for failed login attempts
	Given User is on the login page
	When User enters email <email>
	And User enters password <password>
	And User clicks on the login button
	Then User should see an error message <errorMessage>

	Examples:
	  | email          | password | errorMessage                       |
	  | Dani@gmail.com | Test12   | Login failed: Authentication failed |

  @login
  Scenario Outline: As a user, I should successfully log in with valid credentials
	Given User is on the login page
	When User enters email <email>
	And User enters password <password>
	And User clicks on the login button
	Then User should be successfully logged in and see practice page
	Examples:
	  | email | password |
	  |Dani@gmail.com | Test123.      |

  @purchase
	Scenario Outline: As a user,I should be able to purchase products after logging in
	  Given  user is on learning materials
	  When user selects a product to purchase '<Username>','<password>','<DeviceType>','<brand>','<Storage>','<color>','<Quantity>','<deliveryAddress>','<discount>'
	  And clicks Next button to proceed to checkout
	  Then user should be able to confirm product details
	  And user should be able to complete the purchase
	Examples:
	  | Username       | password | DeviceType | brand       | Storage | color | Quantity | deliveryAddress | discount |
	  | dani@gmail.com | Test123. | Laptop     | Macbook air | 128GB   | Black | 1        | Nairobi         | Save10   |

