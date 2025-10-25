Feature: Invoice Testing Scenarios

  Scenario Outline: Verify single and multi-item invoice correctness
    Given I have completed a purchase with "<items>"
    Then the invoice should list "<expectedItemCount>" items
    And each item should have correct calculated totals

    Examples:
      | items      | expectedItemCount |
      | single     | 1                 |
      | multiple   | 3                 |

  Scenario Outline: Verify discount and additional charges on invoice
    Given I have completed a purchase with "<discountType>" discount, "<shipping>" shipping, and "<warranty>" warranty
    Then the invoice should display discount and all extra charges correctly

    Examples:
      | discountType | shipping | warranty |
      | SAVE10       | Express  | 1yr      |
      | SAVE20       | Standard | 2yr      |

  Scenario: Verify PDF invoice generation and formatting
    Given I view the generated PDF invoice
    Then the PDF should display logo, proper layout, and customer info
    And the "Thank you" message and footer should stay within margins

  Scenario Outline: Verify invoice numbering and history management
    Given I have placed "<invoiceCount>" purchases
    Then invoice numbers should increment sequentially
    And only the last 10 invoices should be retained

    Examples:
      | invoiceCount |
      | 3            |
      | 12           |

  Scenario Outline: View, download, and delete invoice behavior
    Given I have an invoice available
    When I "<action>" the invoice
    Then the system should respond appropriately

    Examples:
      | action         |
      | view           |
      | download       |
      | delete         |

  Scenario: Verify invoice history panel and empty state
    When I open the invoice history panel
    Then it should scroll smoothly and expand
    And if empty, show "No invoices" message

  Scenario: Verify company logo and customer data
    Given I open the invoice
    Then the company logo should display in both HTML and PDF
    And customer name, email, and delivery address should appear in Bill To section
