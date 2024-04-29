package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver ,this);
		
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropDown;
	@FindBy(xpath = "//ul[@class='list-inline']//a[text()='Login']")
	private WebElement login;
	@FindBy(xpath = "//ul[@class='list-inline']//a[text()='Register']")
	private WebElement register;
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBoxField;
	@FindBy(xpath = "//div[@id='search']//button")
	private WebElement searchProductButton;
	
	
    public void clickAccountDropDown() {
    	myAccountDropDown.click();
	}
	public void clickAccountLogin() {
		login.click();
	}
	public void clickAccountRegister() {
		register.click();
	}
	public void enterProductName(String productName) {
		searchBoxField.sendKeys(productName);
	}
	public void clickSearchProductButton() {
		searchProductButton.click();
	}
}
