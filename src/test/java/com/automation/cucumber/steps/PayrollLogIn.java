package com.automation.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PayrollLogIn extends StepBase{

	@When("^I select third party$")
	public void i_select_third_party(){
		payrollloginPage.setThirdPartyIDButton();
	}

	@When("^I insert value in third party ID box$")
	public void i_insert_value_in_third_party_ID_box(){
		String ID = environment.getProperty("partyID");
		payrollloginPage.setThirdPartyIDBox(ID);
		}
	
	@When("^I insert value in user name box$")
	public void i_insert_value_in_user_name_box(){
		String username = environment.getProperty("user_name");
		payrollloginPage.setUserName(username);
	}
	
	@When("^I insert value in password box$")
	public void i_insert_value_in_password_box(){
		String password = environment.getProperty("user_pwd");
		payrollloginPage.setUserpassword(password);
	}

	@When("^I click on Sign on$")
	public void i_click_on_Sign_on(){
		payrollloginPage.clickSignON();
	
	}

	@Then("^I should be looged into the payroll system$")
	public void i_should_be_looged_into_the_payroll_system(){
		String username = environment.getProperty("user_name");
		payrollloginPage.verifyuserlogin(username);
	}
	
	@Given("^I am logged in as an admin to payrool site$")
	public void i_am_logged_in_as_an_admin_to_payrool_site(){
		String username = environment.getProperty("user_name");
		String password = environment.getProperty("user_pwd");
		String ID = environment.getProperty("partyID");
		payrollloginPage.logInPayroll(ID, username, password);
	}


}
