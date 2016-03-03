Feature: Namely Login Functionality

Background:
 Given As not validated user
    When Browse to the application
    Then Namely login page should show


Scenario: 1. Valid user valid password
    When Enter "namelytest1@gmail.com" as emaill address
    And Enter "Test123!" as password
    And Click login
    Then Namely home page should display

@debug  
Scenario Outline: 2. Invalid user or invalid password
    When Enter "<emailaddress>" as emaill address
    And Enter "<password>" as password
    And Click login
    Then Login error message should display
Examples:
|emailaddress                     |password|
|namelytest1@gmail.com            |invalidpassword |
|namelytest1_invalid@gmail.com    |Test123! |