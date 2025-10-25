Feature: Resets & Navigation

  Scenario Outline: Confirm Purchase resets the form
    Given I am on the product page
    And I fill in valid product details "<deviceType>" "<brand>" "<storage>" "<color>" "<quantity>"
    When I click Confirm Purchase
    Then the form should reset to defaults

    Examples:
      | deviceType | brand   | storage | color | quantity |
      | phone      | Apple   | 128GB   | Black | 1        |

  Scenario Outline: Place Order (Cart) resets cart and state
    Given I have multiple items in the cart "<deviceType1>" "<brand1>" "<storage1>" and "<deviceType2>" "<brand2>" "<storage2>"
    When I place the cart order
    Then the cart should be empty
    And the form should reset to defaults

    Examples:
      | deviceType1 | brand1 | storage1 | deviceType2 | brand2 | storage2 |
      | phone       | Apple  | 128GB    | tablet      | Samsung | 64GB     |

  Scenario Outline: Switching tabs resets wizard
    Given I am on the product page
    And I navigate to the "<tabName>" tab
    When I return to the "WebAutomation" tab
    Then the wizard should return to Step1 and be cleared

    Examples:
      | tabName  |
      | API      |
      | Database |
