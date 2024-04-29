package qspiderquestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mystore.utility.Utilities;

public class qSpidersQuestions {
double price;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
                 WebDriver driver = new ChromeDriver();
       
		       //driver.get("https://www.amazon.in/");
                driver.get("https://demo.actitime.com/login.do");
		       driver.manage().window().maximize();
		       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		       
		       /*
		       driver.findElement(By.xpath("//a[text()=\"Today's Deals\"]")).click();
		       Thread.sleep(2000);
		       driver.findElement(By.xpath("//span[text()='Mobiles']")).click();
		       
		      String text = driver.findElement(By.xpath("(//div[text()='Deal of the Day'])[1]/../../following-sibling::a/div")).getText();
		       System.out.println(text);
		       */
		      WebElement element = driver.findElement(By.id("username"));
		       element.sendKeys("admin");
		       Thread.sleep(3000);
		       element.clear();
		       Thread.sleep(3000);
		       

		      driver.quit();
		       
		      
		//qSpidersQuestions obj = new qSpidersQuestions();
		//obj.narrowingAndWidening();
		//obj.ternaryOperator();
			}
	
	
	  public void narrowingAndWidening() {
	 double price=10.0;
		long l = 10;
		char c = 'A';
		int i = c;
		System.out.println(i);
		int x = 66;
		char ch = (char)x;
		System.out.println(ch);
		
		int b=Utilities.a;
        System.out.println(b);
        System.out.println(price);
	}

		
	public void ternaryOperator() {
		int a=65,b=55,c=10;
		boolean bool = true;
	//System.out.println(a>b?a+" is greater": b+" is greater");
	System.out.println(a>b?(a>c?a+" is greatest":c+" is greatest"):(b>c?b+" is greatest":c+" is greatest"));
	
	System.out.println(a=bool?1:0);
	}
	}


