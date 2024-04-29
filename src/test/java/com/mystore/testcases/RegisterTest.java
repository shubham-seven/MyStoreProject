package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.pageobjects.AccountSuccessPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.RegisterPage;
import com.mystore.qa.base.Base;
import com.mystore.utility.Utilities;

public class RegisterTest extends Base{
	 //Remember for screenshots when test got failed we have to make driver public otherwise we will get null pointer exception

	// We are Declaring driver above so as to not to declare in each and every test
	public	WebDriver driver;
		
		public RegisterTest() {
			//Either Explicitly write super or create object of LoginTest class so by default it call Base class constructor
				super();
			}
		
		@BeforeMethod
		public void setUp() throws InterruptedException {
         
			driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
			HomePage homePage = new HomePage(driver);
			homePage.clickAccountDropDown();
			homePage.clickAccountRegister();
			RegisterPage registerPage = new RegisterPage(driver);
			Assert.assertTrue(registerPage.validateAccountRegisterPage());
		}
		
		@Test(priority = 1)
		public void verifyRegisterWithMandatoryFields() throws InterruptedException {
			RegisterPage registerPage = new RegisterPage(driver);
			registerPage.enterFirstName(dataProp.getProperty("firstName"));
			registerPage.enterLastName(dataProp.getProperty("lastName"));
			//See Utilities class where generateEmailWithTimeStamp method is written
			registerPage.enterEmail(Utilities.generateEmailWithTimeStamp());
			
			registerPage.enterTelephone(dataProp.getProperty("telephoneNumber"));
			registerPage.enterPassword(prop.getProperty("validPassword"));
			registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
			
			registerPage.clickCheckBox();
			registerPage.clickSubmitButton();
			
			AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
			String actualSuccessHeading = accountSuccessPage.getTextAccountSuccessfullyCreated();
			Assert.assertEquals(actualSuccessHeading,dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account Success Page is not displayed");

		}
		
		@Test(priority = 2)
		public void verifyRegisterAccountByProvidingAllFields() {
			RegisterPage registerPage = new RegisterPage(driver);
			registerPage.enterFirstName(dataProp.getProperty("firstName"));
			registerPage.enterLastName(dataProp.getProperty("lastName"));
			//See Utilities class where generateEmailWithTimeStamp method is written
			registerPage.enterEmail(Utilities.generateEmailWithTimeStamp());
			
			registerPage.enterTelephone(dataProp.getProperty("telephoneNumber"));
			registerPage.enterPassword(prop.getProperty("validPassword"));
			registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
			
			registerPage.clickYesRadioButton();
            registerPage.clickCheckBox();
			registerPage.clickSubmitButton();
			
			AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
			String actualSuccessHeading = accountSuccessPage.getTextAccountSuccessfullyCreated();
			Assert.assertEquals(actualSuccessHeading,dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account Success Page is not displayed");
		}
		
		
		@Test(priority = 3)
		public void verifyRegisterAccountWithExistingEmailAddress() {
			RegisterPage registerPage = new RegisterPage(driver);
			registerPage.enterFirstName(dataProp.getProperty("firstName"));
			registerPage.enterLastName(dataProp.getProperty("lastName"));
			registerPage.enterEmail(prop.getProperty("validEmail"));
			
			registerPage.enterTelephone(dataProp.getProperty("telephoneNumber"));
			registerPage.enterPassword(prop.getProperty("validPassword"));
			registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
			
			registerPage.clickYesRadioButton();
            registerPage.clickCheckBox();
			registerPage.clickSubmitButton();
			
			String actualWarningMessage = registerPage.getDuplicateEmailAlertMessage();
			Assert.assertTrue(actualWarningMessage.contains(dataProp.getProperty("duplicateEmailWarning")),"Warning mesage for duplicate Email not displayed");
			
		}
		
		@Test(priority = 4)
		public void registerAccountWithoutFillingAnyDetails() {
			RegisterPage registerPage = new RegisterPage(driver);
			registerPage.clickSubmitButton();	
		String warningPrivacyPolicy = registerPage.getPrivacyPolicyAlertMessage();
		Assert.assertEquals(warningPrivacyPolicy,dataProp.getProperty("warningPrivacyPolicy"));

		String warningFirstName = registerPage.getFirstNameAlertMessage();
		Assert.assertEquals(warningFirstName,dataProp.getProperty("warningFirstName"));
	
		String warningLastName = registerPage.getLastNameAlertMessage();
		Assert.assertEquals(warningLastName,dataProp.getProperty("warningLastName"));
		
		String warningEmail = registerPage.getEmailAlertMessage();
		Assert.assertEquals(warningEmail,dataProp.getProperty("warningEmail"));
		
		String warningTelephone = registerPage.getTelephoneAlertMessage();
		Assert.assertEquals(warningTelephone,dataProp.getProperty("warningTelephone"));
		
		String warningPassword = registerPage.getPasswordAlertMessage();
		Assert.assertEquals(warningPassword,dataProp.getProperty("warningPassword"));
		}
        
		
		
		
		
		@AfterMethod
		//We are closing browser in after method b/s if assert fails browser will not be closed b/s 
	   // as assert fails control will come outside test.
		public void tearDown() {
			driver.quit();
		}
}
