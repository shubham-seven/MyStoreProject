package qspiderquestions;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HandlingKeyBoardStrokesUsingKeyClass {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
          WebDriver driver = new EdgeDriver();
          driver.get("https://www.saucedemo.com/v1/");
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
          
          //Normal Way For Login
          /*
          driver.findElement(By.id("user-name")).sendKeys("standard_user");
          driver.findElement(By.id("password")).sendKeys("secret_sauce");r1
          driver.findElement(By.id("login-button")).click();
          */
          
          //Through KeyBoardStrokes approach
         WebElement userName = driver.findElement(By.id("user-name"));
          userName.sendKeys("standard_user");
          Thread.sleep(2000);
          userName.sendKeys(Keys.TAB);
          
          WebElement password = driver.findElement(By.id("password"));
          
          
          //We can perform keys operation in one line as well
          password.sendKeys("secret_sauce",Keys.ENTER);
          
          
	}

}
