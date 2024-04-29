package qspiderquestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CalendarPopup {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		/*
		driver.get("https://www.makemytrip.com/");
		
		//Handling i-frame as without switching frame its not possible to handle elements under i-frame
		WebElement element = driver.findElement(By.name("notification-frame-~251431452"));
		driver.switchTo().frame(element);
		
		driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();

		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		//Here we have found element with ancestor and descendant approach 
		//bcoz in future more webelements gets added so traversing via /.. and // is not recommended
		driver.findElement(By.xpath("//div[text()='November 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='25']")).click();
		*/
		
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath("//div[text()='November 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='25']")).click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		driver.findElement(By.xpath("//a[text()='Cancel']")).click();
	}

}
