# BDD-in-Java-with-JUnit-Spring-and-Cucumber-JVM
BDD in Java with JUnit, Spring and Cucumber-JVM

Cucumber is a very nice testing framework written in the Rubby programming language, which follows the BDD (behavior-driven development) methodology.

Cucumber adds an extra layer of abstraction to our testing paradigm. This layer of abstration is the highest abstraction there is - the English language. Cucucmber converts a feature written in English to executable code, enabling every person, regardless of their coding expertise, to understand exactly what the feature tests and the expected output.

Since this framework is written in Rubby, it doesn't have a straight forward integration with Java. Here, I'll show you one way to start using "Cucumber-Jvm", a Cucumber implementation for the most popular**JVM** languages, using **JUnit** as a runner class. I will also show an integration of **Cucumber** with **Spring**.

##Cucumner basics

As we mentioned, Cucumber converts features written in English to executable code. So, a feature can be thought of as any stateful "black box" in your application that receives input and generates output. Given the "black box" has a state, for each input, we expect to see a specfic output.

Before starting to code, it is considered a good practice to write down the entire feature file. This gives us a general outline of how the code behind the feature should look like.

##Let's get started

Enough with high-level theory, let's see to the underlying details.

A full Cucumber flow is comprised of 3 components: **feature file**, **steps file**, and **runner file**.

##Feature file:
An example of a feature file with one scenario looks like this:
```
**Feature**: Namely New Functionality
**Background:**
Given I Browse to the application
When User login as a valid user
Then Namely home page should display
    
**Scenario:** 1. Logout after successfull login
When User logout from the application
Then Namely login page should show
```
Given, When, and Then are keywords in Gherkin, Cucumber's plain text DSL.

##Steps file:

Cucumber knows how to glue these English sentences to java methods using regexes. The file used to run these sentences is called a "Steps" files, because it runs the feature "step by step". Each step in the feature is matched against a regex, owned by a specific method in the Steps file. Arguments can be passed to the method via the regex.

An example of a Steps file matching the above Given statement of the ".feature" file looks like this:
```
@Given("^I Browse to the application$")
public void browse_to_the_application() throws Throwable {
  String url = environment.getProperty("root.url");
	driver.navigate().to(url);
	}
```


we can use **@Autowired** annotation to build something like a data container object (it should work like a singleton for each scenario) and then autowire it in each stepdefinition classes. 
```
	@Autowired
	protected LoginPage loginPage;
```
##Config Example:
We can also initialize our classes based on our custome annotation

Here, we initialized @PageObject annotation by overriding two methods. 
```
	 @Override
	 public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
	  if (bean.getClass().isAnnotationPresent(PageObject.class)) {
	   PageFactory.initElements(driver, bean);
	  }
	  return bean;
	 }
	 
	 @Override
	 public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
	  return bean;
	 }
```
##Runner file:

The last member when running a cucumber test is the "JUnit-Runner" class, an empty Junit class that is used as a boot class.

An example of a runner class looks like this:
```
@RunWith(Cucumber.class)
@CucumberOptions(
		  dryRun = false,
		  strict = true,
		  monochrome = true,
		  tags = { "@payroll1" },
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

  }
```

Here, we tell JUnit to run the test using Cucumber **- @RunWith(Cucumber.class)**, and tell **"Cucumber-Jvm"** which configurations to run **- @CucucmberOptions**. The location of the ".feature" file as well as the location of the directory containing the Steps file (glue) is mandatory. 

Any Question? just shoot!
	 

