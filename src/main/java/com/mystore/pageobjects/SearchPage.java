package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validHPProductName;
	@FindBy(xpath = "//div[@id='content']/h2/following-sibling::p")
	private WebElement noSuchProductText;

	
	public boolean getDisplayStatusOfValidHPProduct() {
		boolean productDetails = validHPProductName.isDisplayed();
		return productDetails;
	}
	
	public String getNoSuchProductText() {
	String text = noSuchProductText.getText();
	return text;
	}
	
	
}
