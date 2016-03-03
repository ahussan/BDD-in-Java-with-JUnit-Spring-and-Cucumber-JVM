package com.automation.cucumber.steps;

import cucumber.api.java.en.When;

public class HomePageSteps extends StepBase{

	@When("^User logout from the application$")
	public void user_logout_from_the_application() throws Throwable {
	    homePage.logout();
	}
}
