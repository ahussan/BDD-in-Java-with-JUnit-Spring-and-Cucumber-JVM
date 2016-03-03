package com.automation.cucumber.steps;

import org.springframework.beans.factory.annotation.Value;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class ApplicationSteps extends StepBase{

	@Value("${root.url}")
	private String applicationUrl; 
	
	@Given("^As not validated user$")
	public void as_not_validated_user() throws Throwable {
		driver.manage().deleteAllCookies();
	}
	
	@Given("^As a validated user$")
	public void as_a_validated_user() throws Throwable {
		String email = environment.getProperty("user_name");
		String password = environment.getProperty("user_pwd");
		loginPage.login(email, password);
	}

	@When("^I Browse to the application$")
	public void browse_to_the_application() throws Throwable {
		String url = environment.getProperty("root.url");
		driver.navigate().to(url);
	}
	@Given("^User Browse to the application$")
	public void user_Browse_to_the_application() throws Throwable {
		driver.navigate().to(applicationUrl);
	}
	
	
	@When("^User login as a valid user$")
	public void user_login_as_a_valid_user() throws Throwable {
		String email = environment.getProperty("user_name");
		String password = environment.getProperty("user_pwd");
		loginPage.login(email, password);
	}
	

	
}
