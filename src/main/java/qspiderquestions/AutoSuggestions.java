package qspiderquestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AutoSuggestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bluetooth");
        
      List<WebElement> allList = driver.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
      
      for (WebElement list : allList) {
		String str = list.getText();
    	  if (str.equalsIgnoreCase("bluetooth mouse")) {
			list.click();
			break;
		}
	}
	}

}
