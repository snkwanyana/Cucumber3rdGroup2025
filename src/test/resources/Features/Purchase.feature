@purchase
  Feature: I want to purchase an electronic item

    Scenario Outline: As a user i want to purchase an electronic item
      Given I am  on the Practice Assessment page

      Examples:
        | username      | password     | firstName | lastName | zipcode |
        | standard_user | secret_sauce | Nkosi     | Cele     | 2094    |