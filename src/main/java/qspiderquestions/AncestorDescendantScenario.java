package qspiderquestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AncestorDescendantScenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        
      //To close Popup
        driver.findElement(By.xpath("//span[text()='✕']")).click();
         
        WebElement element1 = driver.findElement(By.xpath("//input[@type='text']"));
         element1.sendKeys("iphone");
         element1.sendKeys(Keys.ENTER);
         
      String priceString =   driver.findElement(By.xpath("//div[text()='APPLE iPhone 14 (Blue, 128 GB)']/ancestor::div[@class='_3pLy-c row']/descendant::div[@class='_30jeq3 _1_WHN1']")).getText();
      System.out.println(priceString);
	}

}
