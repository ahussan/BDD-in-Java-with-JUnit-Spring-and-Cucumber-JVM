package com.automation.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginSteps extends StepBase{

	@Then("^Namely login page should show$")
	public void namely_login_page_should_show() throws Throwable {
	    /*String pageTitle;
	    pageTitle = driver.getTitle();
	    assertThat(pageTitle, equalTo("Sign in : Namely on Namely"));*/
		loginPage.verifyPageTitle();
	}

	@When("^Enter \"(.*?)\" as emaill address$")
	public void enter_as_emaill_address(String email) throws Throwable {
	    //driver.findElement(By.id("user_email")).sendKeys(email);
		loginPage.enterEmailAddress(email);
	}

	@When("^Enter \"(.*?)\" as password$")
	public void enter_as_password(String password) throws Throwable {
		 //driver.findElement(By.id("user_password")).sendKeys(password);
		loginPage.enterPassword(password);
	}

	@When("^Click login$")
	public void click_login() throws Throwable {
		//driver.findElement(By.cssSelector(".btn.to-login")).click();
		loginPage.clickLogin();
		delayFor(2000);
	}

	@Then("^Login error message should display$")
	public void login_error_message_should_display() throws Throwable {
		loginPage.verifyLoginErrorMessage();
	}
	
	@Then("^Namely home page should display$")
	public void namely_home_page_should_display() throws Throwable {
		String pageTitle;
	    pageTitle = driver.getTitle();
	    assertThat(pageTitle, equalTo("Home : Namely on Namely"));
	}
	
}
