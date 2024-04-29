package qspiderquestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeWaits {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     /*
Specifies the amount of time the driver should wait when searching for an element if it isnot immediately present. 
When searching for a single element, the driver should poll the page until the element hasbeen found, or this timeout expires before throwing a NoSuchElementException.
Whensearching for multiple elements, the driver should poll the page until at least one elementhas been found or this timeout has expired. 
Increasing the implicit wait timeout should be used judiciously as it will have an adverseeffect on test run time, especially when used with slower location strategies like XPath. 
If the timeout is negative, not null, or greater than 2e16 - 1, an error code with invalidargument will be returned.
Parameters:duration The duration to wait.Returns:A self reference.
	      */
	     driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	     
	     WebElement loginButton = driver.findElement(By.id("login-button"));
	     /*
	     WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));
	     explicitWait.until(ExpectedConditions.elementToBeClickable(loginButton));
	     loginButton.click();
	     */
	     
	     
	    
		FluentWait fluentWait = new FluentWait(driver);
	    		
	    		 fluentWait.pollingEvery(Duration.ofMillis(500));
	    		 fluentWait.withTimeout(Duration.ofSeconds(10));
	    		 fluentWait.until(ExpectedConditions.elementToBeClickable(loginButton));
	    		 loginButton.click();
	     
	}

}
