Feature: Namely New Functionality

Background:
 Given I Browse to the application
 	When User login as a valid user
    Then Namely home page should display

  
Scenario: 1. Logout after successfull login
	When User logout from the application
	Then Namely login page should show    