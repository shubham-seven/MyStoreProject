package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	
	WebDriver driver;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement textAccountSuccessfullyCreated;
	
	
	 public String getTextAccountSuccessfullyCreated() {
		    String validateText = textAccountSuccessfullyCreated.getText();
		    return validateText;
		    }

}
