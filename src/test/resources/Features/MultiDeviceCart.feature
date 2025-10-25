Feature: Multi-Device (2 Types) Cart

  Scenario Outline: Add two different devices and verify multi-type cart
    Given I am on the product page
    When I add a "<firstDeviceType>" "<firstBrand>" "<firstStorage>" with "<firstQty>" qty, "<firstShip>" shipping, "<firstWarranty>" warranty, "<firstDiscount>" discount
    And I add another "<secondDeviceType>" "<secondBrand>" "<secondStorage>" with "<secondQty>" qty, "<secondShip>" shipping, "<secondWarranty>" warranty, "<secondDiscount>" discount
    Then both device types should appear in the cart
    And only "<discountedDevice>" should show discount line
    And the grand total should equal sum of both items

    Examples:
      | firstDeviceType | firstBrand | firstStorage | firstQty | firstShip | firstWarranty | firstDiscount | secondDeviceType | secondBrand | secondStorage | secondQty | secondShip | secondWarranty | secondDiscount | discountedDevice |
      | phone           | Apple      | 64GB         | 1        | standard  | none          | none          | laptop           | MacBook Pro | 256GB         | 1         | express    | 1yr            | SAVE10         | laptop |

  Scenario Outline: Removing one device updates totals and discounts
    Given I have added both "<firstDeviceType>" and "<secondDeviceType>" to the cart
    When I remove "<removedDevice>"
    Then the remaining total should reflect only the other device
    And the discount lines should match the remaining device

    Examples:
      | firstDeviceType | secondDeviceType | removedDevice |
      | phone           | laptop           | laptop         |
      | phone           | laptop           | phone          |

  Scenario Outline: Fast consecutive adds keep original selections
    Given I am on the product page
    When I quickly add "<firstDeviceType>" "<firstBrand>" "<firstStorage>"
    And I immediately add "<secondDeviceType>" "<secondBrand>" "<secondStorage>"
    Then the cart should retain distinct selections for both devices

    Examples:
      | firstDeviceType | firstBrand | firstStorage | secondDeviceType | secondBrand | secondStorage |
      | phone           | Apple      | 64GB         | laptop           | MacBook Pro | 256GB         |
