package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	
	
	public void waitForElementToBeDisplayed(WebElement element, int timeoutPeriod) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutPeriod));
		
			try {
				element.isDisplayed();
				
			} catch (Throwable e) {
				e.printStackTrace();
			}
		
		

	}
	
}
