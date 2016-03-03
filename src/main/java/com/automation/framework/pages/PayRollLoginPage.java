package com.automation.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Service;

@Service
@PageObject
public class PayRollLoginPage extends Page{

	@FindBy(how=How.ID, using="ctl00_mainContent_LogonType_2")
	private WebElement thirdPartyButton;
	
	@FindBy(how=How.ID, using="ctl00_mainContent_ClientCode")
	private WebElement thirdPartyTxtBox;
	
	@FindBy(how=How.ID, using="ctl00_mainContent_UserName")
	private WebElement username;
	
	@FindBy(how=How.ID, using="ctl00_mainContent_Password")
	private WebElement password;
	
	@FindBy(how=How.ID, using="ctl00_mainContent_LoginButton")
	private WebElement signOnButton;
	
	@FindBy(how=How.ID, using="ctl00_mainHeader_HeaderCtl1_CurrentUserLabel")
	private WebElement userlabel;

	public WebElement getThirdPartyButton() {
		return thirdPartyButton;
	}

	public WebElement getThirdPartyTxtBox() {
		return thirdPartyTxtBox;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignOnButton() {
		return signOnButton;
	}
	public WebElement getuserlabel() {
		return userlabel;
	}
	
	public void setThirdPartyIDButton(){
		getThirdPartyButton().click();
		delayFor(3000);
	}
	public void setThirdPartyIDBox(String ID){
		getThirdPartyTxtBox().sendKeys(ID);
	}
	public void setUserName(String ID){
		getUsername().sendKeys(ID);
	}
	public void setUserpassword(String ID){
		getPassword().sendKeys(ID);
	}
	public void clickSignON(){
		getSignOnButton().click();
	}

	public void logInPayroll(String partyID, String username, String password){
		getThirdPartyButton().click();
		delayFor(2000);
		getThirdPartyTxtBox().sendKeys(partyID);
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getSignOnButton().click();
	}
	
	public void verifyuserlogin(String username){
		String text = getuserlabel().getText();
		text = text.toLowerCase();
		username=username.toLowerCase();
		Assert.assertEquals(text, username);
	}
	
}
