package com.automation.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AllCompanyInitialPageSteps extends StepBase{

	

	@When("^I select \"([^\"]*)\" from LoginRole$")
	public void i_select_from_LoginRole(String role)  {
		allCompanyInitialPage.selectByText(role);
	}
	
	@When("^I select first company to log in$")
	public void i_select_first_company_to_log_in(){
		allCompanyInitialPage.FirstCompanyClick();
	
	}
	
	@Then("^I should be logged in$")
	public void i_should_be_logged_in(){
		allCompanyInitialPage.verifyLogedinToCompany();
	
	}
} // end of class
