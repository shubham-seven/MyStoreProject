package qspiderquestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class WebElementsMethods {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();    
		/*
		   driver.get("https://demo.actitime.com/login.do");//for clear() method we used
		   driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	       
	       
	       //BY Method getCSSvalue() we can get font-size,color etc. 
	       
	       
	       
	       //Method to clear text field with use of clear() method
	       WebElement element = driver.findElement(By.id("username"));
	       element.sendKeys("admin");
	       Thread.sleep(3000);
	       element.clear();
	       Thread.sleep(3000);
	       */
	
		//This Url is used for below methods
	       driver.get("https://www.amazon.in");
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//submit() method can be used to click on the button present in the form and Type attribute should be "submit".
//click() method is used to click on the button in the webpage
           /*
	       WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
	       element.sendKeys("bluetooth");
	       Thread.sleep(3000);
	       //We are using submit method as type attribute value is submit.
	        element.submit();
	         
	        */
	       
	       
//For getting location of any WebElement we use getLocation method
	/*
	       WebElement element = driver.findElement(By.id("nav-search-submit-button"));
	   Point loc = element.getLocation();
	   System.out.println(loc.getX());
	   System.out.println(loc.getY());
	   */
	   
	   //getSize method gives size of webelement
	/*   
	  Dimension dimensionOfWebElement = element.getSize();
	   System.out.println(dimensionOfWebElement);
	   System.out.println(dimensionOfWebElement.getHeight());
	   System.out.println(dimensionOfWebElement.getWidth());
	     */
	   //By getRect() method we can get both Location And Size
	   /*
	   Rectangle bothLocationAndSize = element.getRect();
	   System.out.println(bothLocationAndSize.getX());
	   System.out.println(bothLocationAndSize.getY());
	   System.out.println(bothLocationAndSize.getHeight());
	   System.out.println(bothLocationAndSize.getWidth());
	   */
	   
	//isDisplayed() method to check whether element is displayed on the page or not
	       WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
	       
	       if(logo.isDisplayed()) {
	    	   System.out.println("LOGO is displayed");
	       }
	       else {
	    	   System.out.println("LOGO is not displayed");
	       }
	       
//isEnabled() method to check whether element is Enabled(means element is active foreg:text field is disabled from developer side then we check whether it is enabled or not) on the page or not       
	       WebElement ele1	= driver.findElement(By.id("twotabsearchtextbox"));
	       
	       if(ele1.isEnabled()) {
	    	   System.out.println("Element is enabled");
	       }else {
			System.out.println("Element is disabled");
		}
	       
	       
//isSelected() method to check whether element is Selected(generally used for checkboxes,radio button etc.) on the page or not 
//Important Note the element you are checking isSelected() must have type attribute checkbox,radio etc. 	       
	     /*
	       driver.findElement(By.xpath("//span[@class='icp-nav-link-inner']//span[@class='nav-icon nav-arrow']")).click();
	        driver.findElement(By.xpath("(//i[@class='a-icon a-icon-radio'])[2]")).click();
	      WebElement ele2 = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
	       Thread.sleep(3000);
	       if (ele2.isSelected()) {
			System.out.println("Element is Selected");
		} else {
           System.out.println("Element is not Selected");
		}
		*/
	       
//getAttribute Method gives you the attribute value on passing the attribute name	       
	       
	       WebElement ele3 = driver.findElement(By.xpath("//a[text()='Mobiles']"));
	       System.out.println(ele3.getAttribute("class"));
	       
	       
//getTagName() method print the HTML tag of that element
	       
	    WebElement ele4 = driver.findElement(By.xpath("//a[text()='Mobiles']"));
	    System.out.println(ele4.getTagName());
	    
	    
	    
//getAriaRole() method tells what type of element it is
	    WebElement ele5 = driver.findElement(By.xpath("//a[text()=\"Today's Deals\"]"));
	    System.out.println(ele5.getAriaRole());
	    
	    
//getDOMAttribute() method same as getAttribute() method	
	    ele3 = driver.findElement(By.xpath("//a[text()='Mobiles']"));
	       System.out.println(ele3.getDomAttribute("class"));
	       
//getDomProperty() method gives property value of web element corresponding to its property you pass in method 
	       ele3 = driver.findElement(By.xpath("//a[text()='Mobiles']"));
	       System.out.println(ele3.getDomProperty("textContent"));
	       
//getAccessibleName() method gives you the accessible name of the element
	       WebElement ele6 = driver.findElement(By.xpath("//a[text()='Amazon miniTV']"));
	       WebElement ele7 = driver.findElement(By.id("nav-search-submit-button"));
	       System.out.println(ele6.getAccessibleName());
	       System.out.println(ele7.getAccessibleName());
	       
//getText() method gives you the visible text of the element
	       ele6 = driver.findElement(By.xpath("//a[text()='Amazon miniTV']"));
	       System.out.println(ele6.getText());
	       
	       
	       driver.quit();
	}

}
