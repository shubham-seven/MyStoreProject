package com.mystore.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.mystore.utility.Utilities;

public class Base {

	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public Base() {
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mystore\\qa\\config\\config.properties");
		 try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 dataProp = new Properties();
		 File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mystore\\dataprovider\\testdata.properties");
		 try {
		 FileInputStream dataFIS = new FileInputStream(dataPropFile);
		 dataProp.load(dataFIS);
		 }catch (Throwable e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	}
	
	/*
	 * How to use this method mentioned in LoginTest class please check or load properties using constructor
	public void loadPropertiesFile() {
		
		 prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mystore\\qa\\config\\config.properties");
		 
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	
	public WebDriver initializeBrowserAndOpenApplication(String browsername) {
		
		if(browsername.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browsername.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browsername.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if (browsername.equals("safari")) {
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOADOUT_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}
