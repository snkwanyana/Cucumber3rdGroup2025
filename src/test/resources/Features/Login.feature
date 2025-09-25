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
    # New Page for selecting the product
    And User select the device
    And User Select the brand
    And User select the storage
    And User select the color
    And User select Quantity
    And User enters Deliveryemailadd Thulamahashe 1365
    And Calculate the total price
    And User clicks on the next button
    #New Page for shipping details
    And User clicks on the shipping method radio button
    And User clicks on warranty radio button
    And User enters discount code <DiscountCode>
    And User reenters discount code <DiscountsCode>
    And User clicks on Apply button
    Then User Verifies the discount is applied
    And User clicks on the Add to cart button
    #User Select a second device
    And User select DeviceType
    And User Select DeviceBrand
    And User Select deviceStorage
    And User Select DeviceColor
    And user Enters deviceqty <deviceqty>
    And User Enters Deliveryaddress <DeliveryAdd>
    And User Confirms DeviceCurrentPrice

    Examples:
      | emailaddress     | password    | DiscountCode | DiscountsCode |deviceqty|DeliveryAdd         |
      | sama23@gmail.com | Password123 | save10       | save20        |1        |Thulamahashe 1365   |


