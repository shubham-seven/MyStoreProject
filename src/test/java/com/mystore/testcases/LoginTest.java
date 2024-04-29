package com.mystore.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobjects.AccountPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.qa.base.Base;
import com.mystore.utility.Utilities;

public class LoginTest extends Base{
   
	// We are Declaring driver above so as to not to declare in each and every test
//Remember for screenshots when test got failed we have to make driver public otherwise we will get null pointer exception

	public WebDriver driver;
	
	public LoginTest() {
	//Either Explicitly write super or create object of LoginTest class so by default it call Base class constructor
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		//This loadPropertiesFile method is written in Base class for loading properties
	   //This is one way to load properties or we can call constructor of Base class
		//loadPropertiesFile();
		
	    driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		homePage.clickAccountDropDown();
		homePage.clickAccountLogin();
	}
	
	
	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() throws InterruptedException {
		
	    AccountPage accountPage = new AccountPage(driver);
	    LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddressLogin(prop.getProperty("validEmail"));
		loginPage.enterPasswordLogin(prop.getProperty("validPassword"));
		loginPage.clickLoginSubmitButton();
		//Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Edit your account information']")).isDisplayed());
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption());
	}
	
	//Imprortant concept timeout keyword use in TestNG 
	/*
	@Test(timeOut = 1000)
	public void infiniteLoop() {
		int i=1;
		while(i==1){
			System.out.println(1);
		}
	}
	*/
	
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		//See Utilities class where generateEmailWithTimeStamp method is written
		loginPage.enterEmailAddressLogin(Utilities.generateEmailWithTimeStamp());
		loginPage.enterPasswordLogin(dataProp.getProperty("invalidPassword"));
		loginPage.clickLoginSubmitButton();
		
		String alertMessage = loginPage.getAlertMessageLoginText();
	    Assert.assertTrue(alertMessage.equals(dataProp.getProperty("warningMessageInvalidCredentials")));
	  }
	
	@Test(priority = 3)
	public void verifyLoginWithValidEmailInvalidPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddressLogin(prop.getProperty("validEmail"));
		loginPage.enterPasswordLogin(dataProp.getProperty("invalidPassword"));
		loginPage.clickLoginSubmitButton();
		
		String alertMessage = loginPage.getAlertMessageLoginText();
	    Assert.assertTrue(alertMessage.equals(dataProp.getProperty("warningMessageInvalidCredentials")));
		
	}
	
	@Test(priority = 4)
	public void verifyLoginWithInvalidEmailValidPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddressLogin(Utilities.generateEmailWithTimeStamp());
		loginPage.enterPasswordLogin(prop.getProperty("validPassword"));
		loginPage.clickLoginSubmitButton();
		
		String alertMessage = loginPage.getAlertMessageLoginText();
	    Assert.assertTrue(alertMessage.equals(dataProp.getProperty("warningMessageInvalidCredentials")));
		
	}
	@Test(priority = 5)
	public void verifyLoginWithoutCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginSubmitButton();
        
		String alertMessage = loginPage.getAlertMessageLoginText();
	    Assert.assertTrue(alertMessage.equals(dataProp.getProperty("warningMessageInvalidCredentials")));
	}
	
	@Test(priority = 6,dataProvider = "validCredentialsSupplier")
	public void verifyLoginWithValidCredentialsUsingDataProvider(String email,String password) throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		
		loginPage.enterEmailAddressLogin(email);
		loginPage.enterPasswordLogin(password);
		loginPage.clickLoginSubmitButton();		

		//Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Edit your account information']")).isDisplayed());
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption());
		
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData(){
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	@AfterMethod
	//We are closing browser in after method b/s if assert fails browser will not be closed b/s 
   // as assert fails control will come outside test.
	public void tearDown() {
		driver.quit();
	}
	
	
}
