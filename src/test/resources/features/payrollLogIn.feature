Feature: Log in to payroll system

  Background: 
    Given I Browse to the application

  @payroll
  Scenario: 1. Successfull login
    When I select third party
    And I insert value in third party ID box
    And I insert value in user name box
    And I insert value in password box
    And I click on Sign on
    Then I should be looged into the payroll system
  
  @payroll1
  Scenario: 1. select admin and log in to a company
    Given I am logged in as an admin to payrool site
    When I select "Administrator" from LoginRole
    And I select first company to log in
    Then I should be logged in
