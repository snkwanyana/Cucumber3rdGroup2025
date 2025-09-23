@Regression

Feature: Practice Assessments page to access Web Automation in Ndosi platform

  Background:
    Given User is on the login page
    When User enters Email JohnDoe@gmail.com
    And User enters password John@1234
    And User clicks on the login button


  Scenario: As a user, I want to access the practice assessments page to take web automation assessment
    Given User is on the practice assessments page
    When User clicks on the web automation link
    And  User selects device type "Laptop"
    And User selects brand "Macbook pro"
    And User selects storage "256GB"
    And User selects color "White"
    And User enters quantity 4
    And User enters delivery address "123, Baker street, London"
    And User clicks on the next button
    And User selects shipping method "Express"



