package qspiderquestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWebElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.amazon.in");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
       
       
      List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
      int count = 0;
      for (WebElement link : allLinks) {
		System.out.println(link.getText());
		count++;
	}
      System.out.println("total links present on application: "+count);
      driver.quit();
	}

}
