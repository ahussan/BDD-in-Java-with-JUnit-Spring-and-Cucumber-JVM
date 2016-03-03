package com.automation.framework.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Service;

@Service
@PageObject
public class AllCompanyInitialPage extends Page{
	
	@FindBy(how=How.ID, using="ctl00_mainContent_ClientGrid_ctl02_LoginLink")
	private WebElement firstCompanyLogIn;
	
	@FindBy(how=How.ID, using="ctl00_mainHeader_HeaderCtl1_ClientNameLabel")
	private WebElement CompanyNameAfterLogIn;
	
	public WebElement getFirstCompanyLogin(){
		return firstCompanyLogIn;
	}
	
	public WebElement getCompanyNameAfterLogin() {
		return CompanyNameAfterLogIn;
	}

	public Select getRole_Dropdown() {
		Select dropdown = new Select(driver.findElement(By.id("ctl00_mainContent_RoleID")));
		return dropdown;
	}

	public void selectByText(String text){
		getRole_Dropdown().selectByVisibleText(text);
	}
	
	public void selectByIndex(int index){
		getRole_Dropdown().selectByIndex(index);
	}
	
	public void selectByValue(String value){
		getRole_Dropdown().selectByValue(value);
	}
	
	public void FirstCompanyClick(){
		getFirstCompanyLogin().click();
	}
	
	public void verifyLogedinToCompany(){
		delayFor(2000);
		Assert.assertTrue(getCompanyNameAfterLogin().isDisplayed());
	}
	
	
	
}// end of class
