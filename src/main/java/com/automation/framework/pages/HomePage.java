package com.automation.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Service;

@Service
@PageObject
public class HomePage extends Page {

	@FindBy(how=How.XPATH, using="//div[@id='account-menu']/div[@class='dropdown-head']/div[@class='arrow-down']")
	private WebElement accountMenuDownArrow;
	@FindBy(how=How.XPATH, using="//div[@id='account-menu']//a[@id='logout']")
	private WebElement logoutLink;
	
	
	
	public WebElement getAccountMenuDownArrow() {
		return accountMenuDownArrow;
	}
	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public void showAccountDropdownMenu(){
		getAccountMenuDownArrow().click();
	}
	
	public void logout(){
		showAccountDropdownMenu();
		getLogoutLink().click();
	}
	
	
}
