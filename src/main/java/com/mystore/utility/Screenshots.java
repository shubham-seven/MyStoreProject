package com.mystore.utility;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

	public static String takeScreenshot(WebDriver driver,String fileName) throws Throwable {
		
		 fileName = fileName +".png";
		 File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String directory = "C:\\Users\\shubh\\OneDrive\\Desktop\\";
		 String destinationFile = directory+fileName;
		 FileUtils.copyFile(sourceFile, new File(destinationFile));
		 
		 return destinationFile;
	}
}
