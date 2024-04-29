package qspiderquestions;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FlipKartScenario {

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
       
            List<WebElement> mobiles =  driver.findElements(By.xpath("//div[@class='_4rR01T']"));
            int i = 0;int count=0;
        for (WebElement mobile : mobiles) {
        	i++;
        	String mobileName = mobile.getText();
        	String mobilePrice = driver.findElement(By.xpath("(//div[@class='_30jeq3 _1_WHN1'])["+i+"]")).getText();
     mobilePrice  =	mobilePrice.replace("₹","");
     mobilePrice  =  mobilePrice.replace(",","");
     int price = Integer.parseInt(mobilePrice);
     
     if(price>70000) {
    	 count++;
     
        	System.out.println("Mobile Name is "+mobileName+" Mobile Price is "+price);
        	
        }
     
      }
        System.out.println(count);
        //System.out.println(i);
        
	}
}
