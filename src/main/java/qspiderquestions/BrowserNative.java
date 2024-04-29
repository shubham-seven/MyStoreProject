package qspiderquestions;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserNative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//here we are passing arguments one by one
		/*
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notification");
		opt.addArguments("--Incognito");
		*/
		
		//here we are passing all arguments as a list 
		EdgeOptions opt = new EdgeOptions();
		List<String> arguments = new ArrayList<String>();
		arguments.add("--disable-notification");
		arguments.add("--InPrivate");
		opt.addArguments(arguments);
		
		
		//WebDriver driver = new ChromeDriver(opt);
		WebDriver driver = new EdgeDriver(opt);
		driver.get("https://www.flipkart.com");
	}

}
