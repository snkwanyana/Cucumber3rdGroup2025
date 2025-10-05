@ErrorOnlogin
Feature: Login screen for the user to access Ndosi automation platform

  Scenario Outline: As a user, I should see an error message for failed login attempts
	Given User is on the login page
	When User enters email <email>
	And User enters password <password>
	And User clicks on the login button
	Then User should see an error message <errorMessage>

	Examples:
	  | email          | password | errorMessage                         |
	  | Doll@gmail.com |          | Please enter both email and password |
	  | Doll@gmail.com | rfeefef  | Invalid email or password            |
	  |                | Test123. | Please enter both email and password |

  @loginLogout
  Scenario Outline: As a user, I should successfully log in with valid credentials
	Given User is on the login page
	When User enters email <email>
	And User enters password <password>
	And User clicks on the login button
	Then User should be successfully logged in and see practice page
	And User should be successfully logged in and see practice page

	Examples:
	  | email | password |
	  |Doll@gmail.com | Test123.     |

  @SwitchBrowserTabandlogin
  Scenario Outline: As a user, I should be successfully log in after switching browser tabs
  Given User is on the login page
  When User enters email <email>
  And User enters password <password>
  And User clicks on the login button
  Then User should be successfully logged in and see practice page
  And User to switch browser tabs and login again'<UserName>','<Passwords>'
  Examples:
	| email          | password |UserName|Passwords|
	| Doll@gmail.com | Test123. |Doll@gmail.com|Test123.|

  @purchase
	Scenario Outline: As a user,I should be able to purchase products after logging in
	  Given  user is on learning materials
	  When user selects a product to purchase '<Username>','<password>','<DeviceType>','<brand>','<Storage>','<color>','<Quantity>','<deliveryAddress>','<discount>'
	  And clicks Next button to proceed to checkout
	  Then user should be able to confirm product details
	  And user should be able to complete the purchase
	Examples:
	  | Username       | password | DeviceType | brand       | Storage | color | Quantity | deliveryAddress | discount |
	  | Doll@gmail.com | Test123. | Laptop     | Macbook air | 128GB   | Black | 1 1       | Nairobi         | Save10   |


  @Discountpurchase
  Scenario Outline: As a user,I should be able to purchase products after logging in
	Given  user is on learning materials
	When user selects a product to purchase and Discount '<Username>','<password>','<DeviceType>','<brand>','<Storage>','<color>','<Quantity>','<deliveryAddress>','<discount>'
	And clicks Next button to proceed to checkout
	Then user should be able to confirm product details
	And user should be able to complete the purchase
	Examples:
	  | Username | password | DeviceType | brand       | Storage | color | Quantity | deliveryAddress | discount |
	  | Doll@gmail.com | Test123.  | Laptop     | Macbook air | 128GB   | Black | 1        | Nairobi         | Save10   |

  @ValidateQuantity
  Scenario Outline: As a user,I want to validate quantity error message is displayed correctly
	Given  user is on learning materials
	When user selects a product to purchase and Discount '<Username>','<password>','<DeviceType>','<brand>','<Storage>','<color>','<Quantity>','<deliveryAddress>','<discount>','<quantityErrorMsg>'
	And clicks Next button to proceed to checkout
	Then user should be able to confirm product details
	And user should be able to complete the purchase
	Examples:
	  | Username       | password | DeviceType | brand       | Storage | color | Quantity | deliveryAddress | discount | quantityErrorMsg     |
	  | Doll@gmail.com | Test123. | Laptop     | Macbook air | 128GB   | Black | 0        | Nairobi         | Save10   | QUANTITY MUST BE ≥ 1 |
	  | Doll@gmail.com | Test123. | Laptop     | Macbook air | 128GB   | Black | 12       | Nairobi         | Save10   | QUANTITY MUST BE ≤ 10  |

  @pricingPanel1
  Scenario Outline: As a user,I want to validate price details is desh(-) if no device and Storage is selected
	Given  user is on learning materials
	When login  and do not select device and Storage '<Username>','<password>'
	Then user to confirm price details is desh
	Examples:
	  | Username       | password |
	  | Doll@gmail.com | Test123. |

  @pricingPanel1
  Scenario Outline: As a user,I want to validate price details is 400 if device is phone and Storage is 64GB
	Given  user is on learning materials
	When user selects device type and storage '<Username>','<password>','<DeviceType>','<Storage>','<Quantity>'
	Then user should be able to confirm price details is R400
	Examples:
	  | Username | password    | DeviceType | Storage | Quantity |
	  | Doll@gmail.com | Test123. | Phone      | 64GB    | 1        |

  @pricingPanel1
  Scenario Outline: As a user,I want to validate price details is 400 if device is phone and Storage is 64GB
	Given  user is on learning materials
	When user selects device type and storage '<Username>','<password>','<DeviceType>','<Storage>','<Quantity>'
	Then user should be able to confirm price details is R400
	Examples:
	  | Username | password    | DeviceType | Storage | Quantity |
	  | Doll@gmail.com | Test123. | Phone      | 128GB    | 2       |

  @pricingPanel1
  Scenario Outline: As a user,I want to validate price details is 400 if device is phone and Storage is 64GB
	Given  user is on learning materials
	When user selects device type and storage '<Username>','<password>','<DeviceType>','<Storage>','<Quantity>'
	Then user should be able to confirm price details is R400
	Examples:
	  | Username | password    | DeviceType | Storage | Quantity |
	  | Doll@gmail.com | Test123. | Laptop     | 256GB   | 1        |


  @Extrasprices
  Scenario Outline: As a user,I should be able to purchase products after logging in
	Given  user is on learning materials
	When user selects a product to purchase and verify shiping price '<Username>','<password>','<DeviceType>','<brand>','<Storage>','<color>','<Quantity>','<deliveryAddress>','<discount>','<ShippingPrice>'
	And clicks Next button to proceed to checkout
	Then user should be able to select shipping information prices
	And user should be able to complete the purchase
	Examples:
	  | Username       | password | DeviceType | brand   | Storage | color | Quantity | deliveryAddress | discount | ShippingPrice |
	  | Doll@gmail.com | Test123. | Tablet     | Samsung | 128GB   | Black | 1        | Nairobi         | Save10   | Express       |

  @DiscountCodesSingleItem
  Scenario Outline: As a user,I should be able to verify Discount codes for single item purchase
	Given  user is on learning materials
	When user selects a product to purchase '<Username>','<password>','<DeviceType>','<brand>','<Storage>','<color>','<Quantity>','<deliveryAddress>','<discount>','<Discountfeedback>'
	And clicks Next button to proceed to checkout


	Examples:
	  | Username       | password | DeviceType | brand       | Storage | color | Quantity | deliveryAddress | discount | Discountfeedback          |
	  | Doll@gmail.com | Test123. | Laptop     | Macbook air | 128GB   | Black | 1        | Save10          | Save10   | Code SAVE10 applied: -10% |
	  | Doll@gmail.com | Test123. | Laptop     | Macbook air | 128GB   | Black | 1        | Save20          | Save20   | Code SAVE20 applied: -20% |
	  | Doll@gmail.com | Test123. | Laptop     | Macbook air | 128GB   | Black | 1        | 455553          | Save20   | Invalid code              |


  @AddToCartMultiItem
  Scenario Outline: As a user,I should be able to purchase products after logging in
	Given  user is on learning materials
	When user selects a products to purchase  '<Username>','<password>','<DeviceType>','<brand>','<Storage>','<color>','<Quantity>','<deliveryAddress>','<discount>'
	And clicks Next button to proceed to checkout
	Then user should be able to add multiple items to the cart '<DeviceType1>','<brand1>','<Storage1>','<color1>','<Quantity1>','<deliveryAddress1>'

	Examples:
	  | Username       | password | DeviceType | brand       | Storage | color | Quantity | deliveryAddress | discount | DeviceType1 | brand1 | Storage1 | color1 | Quantity1 | deliveryAddress1 |
	  | Doll@gmail.com | Test123. | Laptop     | Macbook air | 128GB   | Black | 1        | Nairobi         | Save10   | Phone       | Xiaomi | 256GB    | Blue   | 1         | Mombasa          |

  @ReviewCartorderflow
Scenario Outline: As a user,I should be able to purchase products after logging in
	Given  user is on learning materials
	When user selects a product to purchase and review cart '<Username>','<password>','<DeviceType>','<brand>','<Storage>','<color>','<Quantity>','<deliveryAddress>','<discount>','<successmessage>'
	And clicks Next button to proceed to checkout
	Then user should be able to confirm product details
	And user should be able to complete the purchase
	Examples:
	  | Username       | password | DeviceType | brand       | Storage | color | Quantity | deliveryAddress | discount | successmessage                              |
	  | Doll@gmail.com | Test123. | Laptop     | Macbook air | 128GB   | Black | 1        | Nairobi         | Save10   | Tester, your order was purchased successfully! |
@ConfirmPurchaseSingle
Scenario Outline: As a user,I should be able to cornfirm purchase for single item
  Given  user is on learning materials
  When user selects a single product to purchase and confirm purchase  '<Username>','<password>','<DeviceType>','<brand>','<Storage>','<color>','<Quantity>','<deliveryAddress>','<discount>','<successmessage>'
  And clicks Next button to proceed to checkout
  Then user should be able to confirm product details
  And user should be able to complete the purchase
  Examples:
	| Username       | password | DeviceType | brand       | Storage | color | Quantity | deliveryAddress | discount | successmessage                                 |
	| Doll@gmail.com | Test123. | Laptop     | Macbook air | 128GB   | Black | 1        | Nairobi         | Save10   | Tester, your order was purchased successfully! |
#	| Doll@gmail.com | Test123. | Phone      | Samsung     | 128GB   | White | 1        | Nairobi         | Save20   | Tester, your order was purchased successfully! |
#	| Doll@gmail.com | Test123. | Tablet     | Apple       | 128GB   | blue  | 1        | Nairobi         | Save10   | Tester, your order was purchased successfully! |

