package qspiderquestions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropDowns {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();
			driver.get("https://www.facebook.com");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	        
	        //We have 3 approaches Using Keys class,Robot class and SelectBy class
	        
	        //This is By Using Keys Class
	        /*
	         driver.findElement(By.xpath("//a[text()='Create new account']")).click();
	         Thread.sleep(2000);
	         
	         WebElement dayList = driver.findElement(By.id("day"));
	         WebElement monthList = driver.findElement(By.id("month"));
	         WebElement yearList = driver.findElement(By.id("year"));
	         
	         dayList.click();
	         dayList.sendKeys(Keys.ARROW_DOWN);
	         dayList.sendKeys(Keys.ARROW_DOWN);
	         dayList.sendKeys(Keys.ARROW_DOWN);
	         dayList.sendKeys(Keys.ARROW_DOWN);
	         dayList.sendKeys(Keys.ARROW_DOWN);
	         dayList.sendKeys(Keys.ARROW_DOWN);
	         dayList.sendKeys(Keys.ENTER);
	         
	         monthList.click();
	         monthList.sendKeys(Keys.ARROW_UP);
	         monthList.sendKeys(Keys.ARROW_UP);
	         monthList.sendKeys(Keys.ARROW_UP);
	         monthList.sendKeys(Keys.ARROW_UP);
	         monthList.sendKeys(Keys.ARROW_UP);
	         monthList.sendKeys(Keys.ENTER);

	         yearList.click();
	         yearList.sendKeys(Keys.ARROW_DOWN);
	         yearList.sendKeys(Keys.ARROW_DOWN);
	         yearList.sendKeys(Keys.ARROW_DOWN);
	         yearList.sendKeys(Keys.ARROW_DOWN);
	         yearList.sendKeys(Keys.ARROW_DOWN);
	         yearList.sendKeys(Keys.ENTER);
	         */
	        
	      //This is By Using Robot Class
	      
	        /*
	        driver.findElement(By.xpath("//a[text()='Create new account']")).click();
	         Thread.sleep(2000);
	         
	        Robot robot = new Robot();
	        
	        WebElement dayList = driver.findElement(By.id("day"));
	         WebElement monthList = driver.findElement(By.id("month"));
	         WebElement yearList = driver.findElement(By.id("year"));
	         
	         dayList.click();
	         robot.keyPress(KeyEvent.VK_NUMPAD6);
	         robot.keyRelease(KeyEvent.VK_NUMPAD6);
	         robot.keyPress(KeyEvent.VK_ENTER);
	         robot.keyRelease(KeyEvent.VK_ENTER);
	         
	         
	         monthList.click();
	         robot.keyPress(KeyEvent.VK_J);
	         robot.keyRelease(KeyEvent.VK_J);
	         robot.keyPress(KeyEvent.VK_J);
	         robot.keyRelease(KeyEvent.VK_J);
	         robot.keyPress(KeyEvent.VK_ENTER);
	         robot.keyRelease(KeyEvent.VK_ENTER);
	         
	         yearList.click();
	         robot.keyPress(KeyEvent.VK_DOWN);
	         robot.keyRelease(KeyEvent.VK_DOWN);
	         robot.keyPress(KeyEvent.VK_DOWN);
	         robot.keyRelease(KeyEvent.VK_DOWN);
	         robot.keyPress(KeyEvent.VK_DOWN);
	         robot.keyRelease(KeyEvent.VK_DOWN);
	         robot.keyPress(KeyEvent.VK_DOWN);
	         robot.keyRelease(KeyEvent.VK_DOWN);
	         robot.keyPress(KeyEvent.VK_DOWN);
	         robot.keyRelease(KeyEvent.VK_DOWN);
	         robot.keyPress(KeyEvent.VK_ENTER);
	         robot.keyRelease(KeyEvent.VK_ENTER);
	         */
	         
	        
	      //This is By Using SelectBy Class
//Inside Select class we have many methods out of which 3 methods are discussed here	        
	        driver.findElement(By.xpath("//a[text()='Create new account']")).click();
	         Thread.sleep(2000);
	         
	         WebElement dayList = driver.findElement(By.id("day"));
	         WebElement monthList = driver.findElement(By.id("month"));
	         WebElement yearList = driver.findElement(By.id("year"));
	         
	         //Remember while using index first value is considered to be at 0 index
	         Select sel = new Select(dayList);
	         //sel.selectByIndex(7);
	         //sel.selectByValue("8");
	         sel.selectByVisibleText("8");
	         
	          sel = new Select(monthList);
	         //sel.selectByIndex(4);
	         //sel.selectByValue("5");
	          sel.selectByVisibleText("May");
	         
	          sel = new Select(yearList);
	         //sel.selectByIndex(4);
	         // sel.selectByValue("2019");
	          sel.selectByVisibleText("2019");
	         
	}

}
