@devicePurchase
Feature: Multi Device Purchase Flow

  Background:
    Given I am on the login screen
    And I enter valid credentials
    And I am redirected to the landing page

  Scenario Outline: User customizes and orders two devices with a discount
    When I navigate to the Web Automation Advanced tab for multi devices

  # First Device
    And I select first device type "<deviceType1>"
    And I select first device brand "<brand1>"
    And I choose first storage option "<storage1>"
    And I choose first color "<color1>"
    And I enter first quantity "<quantity1>"
    And I enter first valid delivery address "<address1>"
    And I click the first Next button
    And I select first shipping method "<shipping1>"
    And I choose first warranty option "<warranty1>"
    And I apply first valid discount code "<code1>"
    And I click the first add to cart button

  # Second Device
    And I select second device type "<deviceType2>"
    And I select second device brand "<brand2>"
    And I choose second storage option "<storage2>"
    And I choose second color "<color2>"
    And I enter second quantity "<quantity2>"
    And I enter second valid delivery address "<address2>"
    And I click the second Next button
    And I select second shipping method "<shipping2>"
    And I choose second warranty option "<warranty2>"
    And I apply second valid discount code "<code2>"
    And I click the second add to cart button

    Then I should see both devices listed in the cart <cartTotal>
    And the total price should reflect applied discounts <expectedTotal>
    And I click the review cart button
    When I click the place order button
    Then an invoice for multi device should be generated
    And I close the invoice browser tab for multi devices
    And I logout from the website for the multi devices

    Examples:
      | deviceType1 | brand1      | storage1 | color1 | quantity1 | address1             | shipping1     | warranty1 | code1  | deviceType2 | brand2 | storage2 | color2 | quantity2 | address2            | shipping2     | warranty2 | code2  | cartTotal | expectedTotal |
      | Phone       | Samsung     | 128GB    | Black  | 3         | 187 Alberto Mansions | Standard      | None      | SAVE10 | Tablet      | Apple  | 256GB    | Gold   | 2         | 789 Park Street     | Express (+25) | 1 Year    | SAVE20 | 2         | 2571.20       |
      | Laptop      | Macbook pro | 256GB    | White  | 5         | 321 Angola Drive     | Express (+25) | 2 Year    | SAVE10 | Phone       | Apple  | 128GB    | Blue   | 1         | 45 Kenilworth Drive | Standard      | None      | SAVE10 | 2         | 6654.6        |


  Scenario Outline: User removes the second device from cart before placing the order
    When I navigate to the Web Automation Advanced tab for multi devices

  # First Device
    And I select first device type "<deviceType1>"
    And I select first device brand "<brand1>"
    And I choose first storage option "<storage1>"
    And I choose first color "<color1>"
    And I enter first quantity "<quantity1>"
    And I enter first valid delivery address "<address1>"
    And I click the first Next button
    And I select first shipping method "<shipping1>"
    And I choose first warranty option "<warranty1>"
    And I apply first valid discount code "<code1>"
    And I click the first add to cart button

  # Second Device
    And I select second device type "<deviceType2>"
    And I select second device brand "<brand2>"
    And I choose second storage option "<storage2>"
    And I choose second color "<color2>"
    And I enter second quantity "<quantity2>"
    And I enter second valid delivery address "<address2>"
    And I click the second Next button
    And I select second shipping method "<shipping2>"
    And I choose second warranty option "<warranty2>"
    And I apply second valid discount code "<code2>"
    And I click the second add to cart button

    Then I should see both devices listed in the cart <cartTotal>
    And the total price should reflect applied discounts <expectedTotal>
    And I click the review cart button


    When I remove the second device from the cart

    Then I should see only the first device in the cart
    And the total price should update to reflect one device <updatedTotal>
    When I click the place order button
    Then an invoice for single device should be generated
    And I close the invoice browser tab for single device
    And I logout from the website for the single device order

    Examples:
      | deviceType1 | brand1  | storage1 | color1 | quantity1 | address1             | shipping1     | warranty1 | code1  | deviceType2 | brand2 | storage2 | color2 | quantity2 | address2            | shipping2     | warranty2 | code2  | cartTotal | expectedTotal | updatedTotal |
      | Phone       | Samsung | 128GB    | Black  | 3         | 187 Alberto Mansions | Standard      | None      | SAVE10 | Tablet      | Apple  | 256GB    | Gold   | 2         | 789 Park Street     | Express (+25) | 1 Year    | SAVE20 | 2         | 2571.20       | 1296.00      |
      | Laptop      | Other   | 64GB     | White  | 5         | 321 Angola Drive     | Express (+25) | 2 Year    | SAVE10 | Phone       | Apple  | 128GB    | Blue   | 1         | 45 Kenilworth Drive | Standard      | None      | SAVE10 | 2         | 5934.60       | 5502.60      |
