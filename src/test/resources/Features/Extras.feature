@Regression
Feature: Extras page to access Web Automation in Ndosi platform

  Background:
    Given User is on the login page
    When User enters Email JohnDoe@gmail.com
    And User enters password John@1234
    And User clicks on the login button
    And User is on the practice assessments page
    And User clicks on the web automation link
    And  User selects device type "Laptop"
    And User selects brand "Macbook pro"
    And User selects storage "256GB"
    And User selects color "White"
    And User enters quantity 4
    And User enters delivery address "123, Baker street, London"
    And User clicks on the next button


  Scenario: As a user, I want to access the practice assessments page to take web automation assessment
    When User selects shipping method "Express (+R25)"
    And User selects warranty "2 Year (+R89)"
    And User enters a discount code "SAVE20"
    And User clicks on apply discount button
    And User clicks on the confirm purchase button
