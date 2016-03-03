package com.automation.framework.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Function;

public abstract class Page {
	
	@Autowired
	protected WebDriver driver;
	private String textToWait;

	public void delayFor(int time){
		 try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	public WebElement waitForElement(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return foo;
	}
	
	public WebElement waitForElementDisplayed(final By locator,int timeToWaitInSec) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeToWaitInSec, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		
		//Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		//((FluentWait<WebDriver>) wait).withTimeout(timeToWaitInSec, TimeUnit.SECONDS);
		//((FluentWait<WebDriver>) wait).pollingEvery(100, TimeUnit.MILLISECONDS);
		//((FluentWait<WebDriver>) wait).ignoring(NoSuchElementException.class);
		
		

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(locator);
				if (element.isDisplayed()) {
					return element;
				}
				return null;
			}
		});
		return foo;
	}
	
	public WebElement waitForElementDisplayed(final By locator) {
		return waitForElementDisplayed(locator,60);
	}
	
	public WebElement waitForElementText(final By locator,String text) {
		textToWait = text;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(locator);
				if (element.getText().contentEquals(textToWait)) {
					return element;
				}
				return null;
			}
		});
		return foo;
	}
	
	public WebElement waitForElementNotDisplayed(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(locator);
				if (element.isDisplayed()) {
					return null;
				}
				return element;
			}
		});
		return foo;
	}
	
}
