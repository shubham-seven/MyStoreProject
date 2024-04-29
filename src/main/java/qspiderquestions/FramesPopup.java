package qspiderquestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesPopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();
		/*
        driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        
        WebElement element = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        //Switching Frame By Index
        driver.switchTo().frame(0);
        //For Switching Back to Default content
        driver.switchTo().defaultContent();
        
        
        //Switching Frame By name Attribute
        
        
        //Switching Frame By using WebElement
        driver.switchTo().frame(element);
        
        WebElement dragElement = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
        WebElement dropElement = driver.findElement(By.xpath("//p[text()='Drop here']"));
        
        Actions action = new Actions(driver);
        action.dragAndDrop(dragElement, dropElement).build().perform();
        */
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        
       // driver.switchTo().frame("SingleFrame");
        driver.switchTo().frame(1);
        
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("shubham");
        
	}

}
