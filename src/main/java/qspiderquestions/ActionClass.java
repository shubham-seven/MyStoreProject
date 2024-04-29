package qspiderquestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();
       // driver.get("https://www.flipkart.com");//this Url for  mousehover and rightclick
		driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
       
        //To close Popup on Flipkart application
       // driver.findElement(By.xpath("//span[text()='✕']")).click();
        
        //Performing Actions Using Action Class (Mouse Hover)
     /*   
     WebElement element1 = driver.findElement(By.xpath("//span[text()='Electronics']"));
     Actions action = new Actions(driver);
     action.moveToElement(element1).perform();
     
		//For performing (Right click)
      action.contextClick(element1).perform();
      */
      
      //Normal Way For Login
      /*
      driver.findElement(By.id("user-name")).sendKeys("standard_user");
      driver.findElement(By.id("password")).sendKeys("secret_sauce");r1
      driver.findElement(By.id("login-button")).click();
      */
      
      //Performing Login using Action Class
      
        Actions action = new Actions(driver);
    WebElement username =  driver.findElement(By.id("user-name"));
    WebElement password = driver.findElement(By.id("password"));
    WebElement loginButton =  driver.findElement(By.id("login-button"));
    /*
    action.sendKeys(username, "standard_user").perform();
    action.sendKeys(password, "secret_sauce").perform();
    action.click(loginButton).perform();
    */
    
    //for performing above action in one line
    //we are using build() before perform() as we are performing multiple action methods in one line
action.sendKeys(username, "standard_user").sendKeys(password, "secret_sauce").click(loginButton).build().perform();
	
	}
}
