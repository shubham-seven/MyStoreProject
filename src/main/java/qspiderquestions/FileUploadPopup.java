package qspiderquestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FileUploadPopup {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();
        driver.get("https://www.foundit.in/");
		
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        
        driver.findElement(By.xpath("//div[contains(text(),'Upload Resume')]")).click();
        
        driver.findElement(By.cssSelector("#file-upload")).sendKeys("C:\\Users\\shubh\\Downloads\\ADVANCE SCENARIO06-11(4pm).txt");
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='close-button mqfi-cross']")).click();
        
	}

}
