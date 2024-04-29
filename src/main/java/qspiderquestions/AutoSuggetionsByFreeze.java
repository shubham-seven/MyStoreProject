package qspiderquestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AutoSuggetionsByFreeze {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
        WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        
      //To close Popup
        driver.findElement(By.xpath("//span[text()='✕']")).click();
        
        WebElement element1 = driver.findElement(By.xpath("//input[@type='text']"));
        element1.sendKeys("phone");
        Thread.sleep(2000);
        List<WebElement> allSugg = driver.findElements(By.xpath("//ul[@class='_1sFryS _2x2Mmc _3ofZy1']//li"));
        
        for (WebElement sugg : allSugg) {
			String text = sugg.getText();
			System.out.println(text);
			
			if (text.equalsIgnoreCase("phone cover")) {
				sugg.click();
				break;
			}
		}
        
	}

}
