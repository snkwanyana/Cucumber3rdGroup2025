Feature: Invoice Page Structure

  Scenario: Verify invoice structure is complete and professional
    Given I am on the invoice page
    Then the company logo should be visible
    And customer name "Hisense Crock", email "HisenseCrock@example.com", and address "321 Angola Drive" should be visible
    And the invoice should contain an itemized list
    And the invoice status should be "Paid"
    And the totals section should display subtotal "6480.00", shipping "25.00", and total "5934.60"
    And the page should display a thank you message "Thank you for your business!"
    And the invoice should have professional formatting