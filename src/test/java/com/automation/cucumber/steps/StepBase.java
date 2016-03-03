package com.automation.cucumber.steps;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.automation.framework.pages.AllCompanyInitialPage;
import com.automation.framework.pages.HomePage;
import com.automation.framework.pages.LoginPage;
import com.automation.framework.pages.PayRollLoginPage;

public class StepBase {
	@Autowired
	protected WebDriver driver;
	@Autowired
	protected Environment environment;
	
	@Autowired
	protected LoginPage loginPage;
	@Autowired
	protected HomePage homePage;

	@Autowired
	protected PayRollLoginPage payrollloginPage;
	
	@Autowired
	AllCompanyInitialPage allCompanyInitialPage;
	
	
	protected void delayFor(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
