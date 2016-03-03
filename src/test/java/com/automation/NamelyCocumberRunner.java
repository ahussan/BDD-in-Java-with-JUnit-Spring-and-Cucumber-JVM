package com.automation;


import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.util.StringUtils;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		  //dryRun = false,
		  //strict = true,
		  monochrome = true,
		  tags = { "@payroll1" },

		  //tags = { "@debug" },
		  //tags = { "@functional","@smoke" }, /*AND*/
		  //tags = { "@functional,@smoke" }, /*OR*/
		  //tags = { "@functional,@debug","@debug" }, /*AND-OR*/
		  features = "src/test/resources/features",
		  glue = {"com.namely.automation.framework.hook","com.namely.automation.cucumber.steps"},
		  plugin={
			 "pretty",
			 "html:target/test-report",
			 "json:target/test-report.json",
			 "json:target/cucumber-report.json",
			 "junit:target/test-report.xml"
		  	}
		)
public class NamelyCocumberRunner {

	@BeforeClass
	public static void setUp(){
		String envTarget = System.getProperty("envTarget");
        if (!StringUtils.hasText(envTarget)) {
            envTarget = "QApayroll";  //"default";
            System.setProperty("envTarget", envTarget);
        }
        
        String browser = System.getProperty("browser");
	    if(!StringUtils.hasText(browser)){
	        browser = "ff";
	        System.setProperty("browser", browser);
	    }
	}

	
}
