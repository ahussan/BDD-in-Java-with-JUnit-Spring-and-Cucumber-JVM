package com.automation.framework.pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Service;

@Service
@PageObject
public class LoginPage extends Page{

	@FindBy(how=How.ID, using="user_email")
	private WebElement emailTextbox;
	@FindBy(how=How.ID, using="user_password")
	private WebElement passwordTextbox;
	@FindBy(how=How.CSS, using=".btn.to-login")
	private WebElement loginButton ;
	
	private WebElement errorMsg;
	
	
	public WebElement getEmailTextbox() {
		return emailTextbox;
	}
	public WebElement getPasswordTextbox() {
		return passwordTextbox;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public WebElement getErrorMsg() {
		errorMsg = waitForElement(By.cssSelector(".message.alert"));
		return errorMsg;
	}
	
	
	public void enterEmailAddress(String email){
		getEmailTextbox().sendKeys(email);
	}
	
	public void enterPassword(String password){
		getPasswordTextbox().sendKeys(password);
	}
	
	public void clickLogin(){
		getLoginButton().click();
	}
	
	
	
	public void login(String email,String password){
		enterEmailAddress(email);
		enterPassword(password);
		clickLogin();
		delayFor(2000);
	}
	
	public void verifyLoginErrorMessage() throws Throwable {
		boolean isErrorDisplayed = getErrorMsg().isDisplayed();
		assertThat(isErrorDisplayed, equalTo(true));
		String msg = getErrorMsg().getText();
	    assertThat(msg, equalTo("Invalid email or password."));
	}
	
	public void verifyPageTitle() throws Throwable {
		String pageTitle;
	    pageTitle = driver.getTitle();
	    assertThat(pageTitle, equalTo("Sign in : Namely on Namely"));
	}
}
