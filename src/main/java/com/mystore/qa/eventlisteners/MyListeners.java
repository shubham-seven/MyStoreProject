package com.mystore.qa.eventlisteners;



import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mystore.utility.ExtentReporter;
import com.mystore.utility.Screenshots;

public class MyListeners implements ITestListener {
	
	ExtentReports extentReport ;
	ExtentTest extentTest;
	
	public void onStart(ITestContext context) {
		extentReport = ExtentReporter.generateExtentReport();
	}

	public void onTestStart(ITestResult result) {
	String testName = result.getName();
	extentTest = extentReport.createTest(testName);
	extentTest.log(Status.INFO, testName+" Started Executing");
	}

	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.PASS, testName+" got successfully executed");
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
	WebDriver driver=null;
	try {
		driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchFieldException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		String path = Screenshots.takeScreenshot(driver, testName);
	    extentTest.addScreenCaptureFromPath(path);
	    
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL, testName+" got failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.SKIP, testName+" got skipped");
		//System.out.println(result.getName()+" got skipped");
		//System.out.println(result.getThrowable());
	}

	

	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

	
}
