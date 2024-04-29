package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.SearchPage;
import com.mystore.qa.base.Base;

public class Search extends Base {
 //Remember for screenshots when test got failed we have to make driver public otherwise we will get null pointer exception
	public WebDriver driver;
	
	public Search() {
		//Either Explicitly write super or create object of LoginTest class so by default it call Base class constructor
			super();
		}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
        
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		
	}
	
	@Test(priority = 1,invocationCount = 2)
	public void verifySearchWithValidProduct() throws InterruptedException {
		
		HomePage homePage = new HomePage(driver);
		SearchPage searchPage = new SearchPage(driver);
		homePage.enterProductName("HP");
		homePage.clickSearchProductButton();
		Assert.assertTrue(searchPage.getDisplayStatusOfValidHPProduct());
		
	}
	
	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		SearchPage searchPage = new SearchPage(driver);
		homePage.enterProductName("Honda");
		homePage.clickSearchProductButton();
		String actualSearchMessage = searchPage.getNoSuchProductText();
		Assert.assertEquals(actualSearchMessage,dataProp.getProperty("noProductTextInSearchResults"),"Message not displayed");
	}
	
	@Test(priority = 3,dependsOnMethods = "verifySearchWithInvalidProduct",invocationCount = 1)
	public void verifySearchWithoutAnyProduct() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.clickSearchProductButton();
		SearchPage searchPage = new SearchPage(driver);
		String actualSearchMessage = searchPage.getNoSuchProductText();
		Assert.assertEquals(actualSearchMessage,dataProp.getProperty("noProductTextInSearchResults"),"Message not displayed");
	}
	
	
	
	
	
	
	
	
	@AfterMethod
	//We are closing browser in after method b/s if assert fails browser will not be closed b/s 
   // as assert fails control will come outside test.
	public void tearDown() {
		driver.quit();
	}
}
