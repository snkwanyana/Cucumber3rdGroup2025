@invoice
Feature: Invoice Page Validation

  Scenario: Validate contents of the invoice page
    Given I am on the invoice page
    Then I should see the company logo
    And I should see customer details
    And I should see invoice details
    And I should see the itemized list of products
    And I should see the totals including discounts and final total "R5934.60"
    And I should see professional formatting elements
