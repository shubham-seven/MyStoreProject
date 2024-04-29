package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[text()='Register Account']")
	private WebElement textAccountRegister;
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	@FindBy(id = "input-email")
	private WebElement emailField;
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	@FindBy(id = "input-password")
	private WebElement passwordField;
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkBox;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitButton;
	@FindBy(xpath = "//label[text()='Yes']/input")
	private WebElement yesRadioButton;
	@FindBy(xpath = "//label[text()='No']/input")
	private WebElement noRadioButton;
	@FindBy(xpath = "//div[contains(@class,'alert')]")
	private WebElement duplicateEmailAlert;
	@FindBy(xpath = "//div[contains(@class,'alert')]")
	private WebElement warningPrivacyPolicy;
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement warningFirstName;
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement warningLastName;
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement warningEmail;
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement warningTelephone;
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement warningPassword;
	
	
	
	public boolean validateAccountRegisterPage() {
	boolean textvalidate  = textAccountRegister.isDisplayed();
	return textvalidate;
	}
	
	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}
    public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
    public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
    public void enterTelephone(String telephone) {
	telephoneField.sendKeys(telephone);
    }
    public void enterPassword(String password) {
	passwordField.sendKeys(password);
    }
    public void enterConfirmPassword(String confirmPassword) {
	confirmPasswordField.sendKeys(confirmPassword);
    }
    public void clickCheckBox() {
    	checkBox.click();
    }
    public void clickSubmitButton() {
    	submitButton.click();
    }
    public void clickYesRadioButton() {
    	yesRadioButton.click();
    }
    public void clickNoRadioButton() {
    	noRadioButton.click();
    }
    public String getDuplicateEmailAlertMessage() {
    	String alertMessage = duplicateEmailAlert.getText();
    	return alertMessage;
    }
    public String getPrivacyPolicyAlertMessage() {
    	String alertMessage = warningPrivacyPolicy.getText();
    	return alertMessage;
    }
    public String getFirstNameAlertMessage() {
    	String alertMessage = warningFirstName.getText();
    	return alertMessage;
    }
    public String getLastNameAlertMessage() {
    	String alertMessage = warningLastName.getText();
    	return alertMessage;
    }
    public String getEmailAlertMessage() {
    	String alertMessage = warningEmail.getText();
    	return alertMessage;
    }
    public String getTelephoneAlertMessage() {
    	String alertMessage = warningTelephone.getText();
    	return alertMessage;
    }
    public String getPasswordAlertMessage() {
    	String alertMessage = warningPassword.getText();
    	return alertMessage;
    }
    
}
