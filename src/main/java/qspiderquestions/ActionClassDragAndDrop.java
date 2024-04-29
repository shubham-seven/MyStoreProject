package qspiderquestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
	        //driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		    //driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		    driver.get("https://www.makemytrip.com/flights/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	        
	       
	        Actions action = new Actions(driver);
	        /*
	        WebElement dragElement = driver.findElement(By.id("draggable"));
	        Thread.sleep(2000);
	        WebElement dropElement = driver.findElement(By.id("droppable"));
	        action.dragAndDrop(dragElement, dropElement).perform();
            */
	        /*
	        WebElement element1 = driver.findElement(By.xpath("//button[@ondblclick]"));
	        action.doubleClick(element1).perform();
	        */
	        
	        //for performing tap on random area on web page to close the popup
	        //not every popup can be closed by random tap remember
	        action.moveByOffset(10, 10).click().perform();
	        
	}

}
