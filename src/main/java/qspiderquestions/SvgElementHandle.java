package qspiderquestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SvgElementHandle {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
        driver.get("https://www.kayak.co.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        
        
        //Syntax for finding SVG Elements //*[name()='svg' and @AtrributeName='AttributeValue']
        
        driver.findElement(By.xpath("//*[name()='svg' and @class='c8LPF-icon']")).click();
        
        driver.findElement(By.xpath("//*[@class='dDYU-closeIcon dDYU-mod-theme-default']")).click();

        
	}

}
