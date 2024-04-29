package qspiderquestions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollHandlingUsingRobotAndJSExecutor {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		
				WebDriver driver = new EdgeDriver();
		     //driver.get("https://www.amazon.in");
				driver.get("https://www.facebook.com");
		     driver.manage().window().maximize();
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		     driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		    
		     /*
		     Robot robot = new Robot();
		     robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		     robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		     Thread.sleep(2000);
		     robot.keyPress(KeyEvent.VK_PAGE_UP);
		     robot.keyRelease(KeyEvent.VK_PAGE_UP);
		     */
		     /*
		     JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		     //For scrolling down
		     for(int i=0;i<5;i++) {
		     jsExecutor.executeScript("window.scrollBy(0,500);");
		     Thread.sleep(2000);
				
		     }	
		     //For scrolling up just put minus sign before y co-ordinate
		     for(int i=0;i<3;i++) {
		     jsExecutor.executeScript("window.scrollBy(0,-500);");
		     Thread.sleep(2000);
				
		     }	
		     */
		     
		     JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		     
		     WebElement element1 = driver.findElement(By.xpath("//a[text()='Video']"));
		     /*
		     Point loc =element1.getLocation();
		     System.out.println(loc.getY());
		     //here we have to pass har value we cant pass variable as we are sending in string format
		     jsExecutor.executeScript("window.scrollBy(0,732)");
		     element1.click();
		     */
		     
		     // Another approach for above scroll i.e scrollIntoView
			  // jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element1);  
			 //  jsExecutor.executeScript("arguments[0].scrollIntoView(false);", element1);
			   //element1.click();
			 /*  
A boolean value:

If true, the top of the element will be aligned to the top of the visible area of the scrollable ancestor. 
Corresponds to scrollIntoViewOptions: {block: "start", inline: "nearest"}. This is the default value.
If false, the bottom of the element will be aligned to the bottom of the visible area of the scrollable ancestor.
 Corresponds to scrollIntoViewOptions: {block: "end", inline: "nearest"}.
 you can check by running the above example;
 */
		     
		     
		   //For Scrolling to the Bottom of the page and Scrolling to top of the page
		     
		     jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");//for bottom
		     Thread.sleep(2000);
		     jsExecutor.executeScript("window.scrollBy(0,-document.body.scrollHeight)");//for top
	}
	

	
	

}
