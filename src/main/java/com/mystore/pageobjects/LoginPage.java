package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	private WebElement emailFieldLogin;
	@FindBy(id = "input-password")
	private WebElement passwordFieldLogin;
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginSubmitButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertMessageLogin;
	
	
	public void enterEmailAddressLogin(String email) {
		emailFieldLogin.sendKeys(email);
	}
	
    public void enterPasswordLogin(String password) {
		passwordFieldLogin.sendKeys(password);
	}
    public void clickLoginSubmitButton() {
	 loginSubmitButton.click();
    }
    public String getAlertMessageLoginText() {
    	String alertMeassage = alertMessageLogin.getText();
    	return alertMeassage;
    }
}
