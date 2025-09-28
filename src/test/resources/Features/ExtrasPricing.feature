Feature: Pricing calculation with various options

  Scenario Outline: Pricing calculation with various options
    Given the user is on the pricing panel
    When the user selects "<shipping>" shipping
    And selects "<warranty>" warranty
    And enters discount code "<discount>"
    And sets quantity to <quantity>
    Then the base price should be "<base>"
    And the subtotal should be "<subtotal>"
    And the discount should be "<discountValue>"
    And the total should be "<total>"

    Examples:
      | shipping | warranty | discount | quantity | base    | subtotal | discountValue | total   |
      | Standard | None     |          | 1        | R400.00 | R400.00  |               | R400.00 |
     #| Express  | 1yr      | SAVE10   | 2        | R400    | R1,034   | R103.40       | R930.60 |
     # | Express  | 2yr      |          | 1        | R480    | R594     |               | R594.00 |